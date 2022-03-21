package danggai.app.lockscreenexample.ui.homeforward

import android.app.ActivityManager
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import danggai.app.lockscreenexample.service.ManageForegroundService
import danggai.app.lockscreenexample.ui.lockscreen.LockScreenActivity
import danggai.app.lockscreenexample.util.log


class HomeForwardActiviity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        log.e()
        parse()
    }

    private fun parse() {
//        LockScreenActivity.startActivity(this)
        ManageForegroundService.startService(applicationContext)

        finish()
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        parse()
    }

    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        for (service in manager.getRunningServices(Int.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}