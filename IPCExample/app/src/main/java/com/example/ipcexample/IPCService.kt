package com.example.ipcexample

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log

class IPCService : Service() {

    var value = 0
    var thread: ThreadClass? = null
    var binder: IBinder= LocalBinder()

    override fun onBind(intent: Intent): IBinder {      // 접속하는 액티비티 측에서 IBinder 형태의 값을 받음.
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread = ThreadClass()
        thread?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class ThreadClass : Thread() {
        override fun run() {
            while(true) {
                SystemClock.sleep(1000)
                Log.d("test1", "value: ${value++}")
            }
        }
    }

    inner class LocalBinder: Binder() {

        fun getService() : IPCService{     // IPCService로부터 만든 객체의 주솟값을 받아옴.
            return this@IPCService
        }
    }

    fun getNumber(): Int{
        return value
    }
}
