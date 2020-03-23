package com.example.serviceexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var service_intent: Intent?= null

    var permission_list = arrayOf(
        Manifest.permission.FOREGROUND_SERVICE,
        Manifest.permission.INSTANT_APP_FOREGROUND_SERVICE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermission()

        btn1.setOnClickListener {
            service_intent = Intent(applicationContext, BasicService::class.java)
            startService(service_intent)
        }
        btn2.setOnClickListener {
            service_intent = Intent(applicationContext, BasicService::class.java)
            stopService(service_intent)
        }
        btn3.setOnClickListener {
            service_intent = Intent(applicationContext, IntentService::class.java)
            startService(service_intent)
            finish()
        }
        btn4.setOnClickListener {
            service_intent = Intent(this, ForegroundService::class.java)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(service_intent)
            } else {
                startService(service_intent)
            }
        }
    }

    fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission: String in permission_list) {
                var chk = checkCallingOrSelfPermission(permission)
                if (chk == PackageManager.PERMISSION_DENIED) {
                    requestPermissions(permission_list, 0)
                    break
                }
            }
        }
    }
}
