package com.example.serviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.view.Gravity
import android.widget.Toast

class BasicService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var thread = ThreadClass()
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d("test", "Service Destoried.")
        super.onDestroy()
    }

    inner class ThreadClass: Thread() {
        override fun run() {
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("test", "Service Running ${time}")
//            Log.d("test", "Service Done.")
            run()
        }
    }
}
