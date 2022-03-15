package danggai.app.lockscreenexample.ui.lockscreen

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import danggai.app.lockscreenexample.R
import danggai.app.lockscreenexample.databinding.LockScreenActivityBinding

class LockScreenActivity : AppCompatActivity() {

    private lateinit var binding: LockScreenActivityBinding

    companion object {
        const val layoutResId = R.layout.lock_screen_activity

        fun startActivity(act: Activity) {
            val intent = Intent(act, LockScreenActivity::class.java)
            act.startActivity(intent)
        }

        fun startActivity(context: Context) {
            val intent = Intent(context, LockScreenActivity::class.java)
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
}