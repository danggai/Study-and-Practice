package com.example.serviceexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var builder: NotificationCompat.Builder?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var channel = NotificationChannel("test1", "Service", NotificationManager.IMPORTANCE_HIGH)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)

            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, "test1")
        } else {
            builder = NotificationCompat.Builder(this)
        }

        builder?.setSmallIcon(android.R.drawable.ic_menu_camera)
        builder?.setContentTitle("Foreground Service 가동")
        builder?.setContentText("Foreground Service가 가동중입니다.")
        var notification = builder?.build()

        startForeground(54, notification)

        var thread = ThreadClass()
        thread.start()
        return super.onStartCommand(intent, flags, startId)
    }

    inner class ThreadClass: Thread () {
        override fun run() {
            var idx = 0
            while (idx++ < 10) {
                SystemClock.sleep(1000)
                var time = System.currentTimeMillis()
                Log.d("test", "foreground Service Running: ${time}")
            }
        }
    }
}
