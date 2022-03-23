package danggai.app.lockscreenexample.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import danggai.app.lockscreenexample.service.ManageForegroundService
import danggai.app.lockscreenexample.util.log

class ScreenOffReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.


        when (intent.action) {
            Intent.ACTION_SCREEN_ON -> {
                log.e("ACTION_SCREEN_ON")

            }
            Intent.ACTION_SCREEN_OFF -> {
                log.e("ACTION_SCREEN_OFF")

                ManageForegroundService.initService(context)
//                LockScreenActivity.startActivity(context)
            }
            Intent.ACTION_BOOT_COMPLETED,
            Intent.ACTION_LOCKED_BOOT_COMPLETED -> {
                ManageForegroundService.initService(context)
            }
            else -> {

            }
        }
    }
}