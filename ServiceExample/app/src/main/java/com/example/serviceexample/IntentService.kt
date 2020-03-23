package com.example.serviceexample

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.os.SystemClock
import android.util.Log
import android.view.Gravity
import android.widget.Toast

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class IntentService : IntentService("ServiceClass2") {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {      // 이 함수 자체로 별도의 스레드 클래스를 생성함.
        var idx = 0
        while ( idx++ < 10) {
            SystemClock.sleep(1000)
            var time = System.currentTimeMillis()
            Log.d("test","Intent Service Running ${time}")
        }
    }
}
