package danggai.app.lockscreenexample.ui.homeforward

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import danggai.app.lockscreenexample.ui.lockscreen.LockScreenActivity
import danggai.app.lockscreenexample.util.log


class HomeForwardActiviity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log.e()
        parse()
    }

    private fun parse(){

        // TODO(Foreground Service 여부 확인하여 없으면 LockScreenActivity 실행)
//        if (isAuthValid(_intent)) {
        log.e()
        LockScreenActivity.startActivity(this)
//        } else {
//            finish()
//        }

        finish()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        parse()
    }

    private fun isAuthValid() {
        // TODO(foreground service 체크)
    }

}