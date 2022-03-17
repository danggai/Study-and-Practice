package danggai.app.lockscreenexample.ui.lockscreen

import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import danggai.app.lockscreenexample.R
import danggai.app.lockscreenexample.databinding.LockScreenFragmentBinding
import danggai.app.lockscreenexample.service.ManageForegroundService
import danggai.app.lockscreenexample.util.log
import danggai.app.resinwidget.util.EventObserver

class LockScreenFragment : Fragment() {

    companion object {
        fun newInstance() = LockScreenFragment()
        const val layoutResId = R.layout.lock_screen_fragment
    }

    private lateinit var viewModel: LockScreenViewModel
    private lateinit var binding: LockScreenFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<LockScreenFragmentBinding>(inflater, layoutResId, container, false).apply { binding = this }.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LockScreenViewModel::class.java)

        binding.vm = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initLv()
    }

    private fun initLv() {
        viewModel.lvEventUnlock.observe(viewLifecycleOwner, EventObserver {
             if (it) {
                 activity?.let { activity ->
                     log.e()
                     ManageForegroundService.startService(requireContext())
                     activity.finishAffinity()
                 }
             }
        })
    }

}