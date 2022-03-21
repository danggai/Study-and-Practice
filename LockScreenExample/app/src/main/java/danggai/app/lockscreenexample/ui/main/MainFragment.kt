package danggai.app.lockscreenexample.ui.main

import android.annotation.TargetApi
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import danggai.app.lockscreenexample.R
import danggai.app.lockscreenexample.databinding.MainFragmentBinding
import danggai.app.lockscreenexample.service.ManageForegroundService
import danggai.app.lockscreenexample.ui.ScreenOffReceiver
import danggai.app.lockscreenexample.util.log
import danggai.app.resinwidget.util.EventObserver


class MainFragment : Fragment() {

    companion object {
        const val layoutResId = R.layout.main_fragment
        var ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 5469
        fun newInstance() = MainFragment()
    }



    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return DataBindingUtil.inflate<MainFragmentBinding>(inflater, layoutResId, container, false).apply { binding = this }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.vm = viewModel

        initLv()

        checkPermission()
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE) {
            if (!Settings.canDrawOverlays(context)) {
                // You don't have permission
                checkPermission()
            } else {
                // Do as per your logic
            }
        }
    }


    private fun initLv() {

        viewModel.lvEventLockScreenEnable.observe(viewLifecycleOwner, EventObserver { boolean ->
            context?.let { context ->

                val receiver = ScreenOffReceiver()
                val filter = IntentFilter(Intent.ACTION_SCREEN_OFF).apply {
                    this.addAction(Intent.ACTION_SCREEN_ON)
                }

                if (boolean) {
                    ManageForegroundService.initService(context)
                    context.registerReceiver(receiver, filter)
                    requireActivity().finish()
                } else {
                    ManageForegroundService.stopService(context)
                    try {
                        context.unregisterReceiver(receiver);
                    } catch (e: IllegalArgumentException){
                        log.e()
                    } catch (e: Exception) {
                        log.e()

                    }

                }
            }
        })
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(context)) {
                val intent =  Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:${activity?.packageName}"))

                startActivityForResult(intent, ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE)
            }
        }
    }

}