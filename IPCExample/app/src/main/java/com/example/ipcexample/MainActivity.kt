package com.example.ipcexample

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var ipc_service: IPCService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent(this, IPCService::class.java)
        if(isServiceRunning("com.example.ipcexample") == false) {
            startService(intent)
        }
        bindService(intent, mConnection,
            Context.BIND_AUTO_CREATE)  // 서비스가 실행중이지 않으면 실행시키고 작동.

        btn1.setOnClickListener {
            var value = ipc_service?.getNumber()
            txtView1.text = "value: ${value}"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(mConnection)
    }

    fun isServiceRunning(name: String): Boolean {
        var manager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        for (service: ActivityManager.RunningServiceInfo in manager.getRunningServices(Int.MAX_VALUE)) {
            if(service.service.className.equals(name)) {
                return true
            }
        }
        return false
    }

    private val mConnection = object: ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName?) {
            ipc_service = null
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            var binder = service as IPCService.LocalBinder
            ipc_service = binder.getService()
        }

    }

}
