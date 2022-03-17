package danggai.app.lockscreenexample.ui.lockscreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import danggai.app.lockscreenexample.R
import danggai.app.lockscreenexample.databinding.LockScreenActivityBinding
import danggai.app.lockscreenexample.util.log


class LockScreenActivity : AppCompatActivity() {

    private lateinit var binding: LockScreenActivityBinding

    companion object {
        const val layoutResId = R.layout.lock_screen_activity

        fun startActivity(act: Activity) {
            log.e()

            val intent = Intent(act, LockScreenActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            act.startActivity(intent)
        }

        fun startActivity(context: Context) {
            log.e()

            val intent = Intent(context, LockScreenActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            context.startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResId)

        setContentView(R.layout.lock_screen_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LockScreenFragment.newInstance())
                .commitNow()
        }
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)

        if (Build.VERSION.SDK_INT >= 27)
            setShowWhenLocked(true);
        else
            window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);

    }

    override fun onBackPressed() {

    }

}