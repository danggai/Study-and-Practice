package com.example.notificationexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
//            var builder = NotificationCompat.Builder(this)
            var builder = getNotificationBuilder("channel1", "first channel")       // android 8.0부터는 notification channal이라는 기능이 생김. 한 채널이라는 그룹으로 알람 메시지를 묶는 개념.
            builder.setTicker("Ticker")         // android 4.1부터는 ticker이 표시되지 않음
            builder.setNumber(100)              // android 4.1부터는 number 또한 표시되지 않음
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title1")
            builder.setContentText("Content Text1")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(10, notification)    // 알람을 구분하기 위한 id값.
        }

        btn2.setOnClickListener {
//            var builder = NotificationCompat.Builder(this)
            var builder = getNotificationBuilder("channel1", "first channel")       // android 8.0부터는 notification channal이라는 기능이 생김. 한 채널이라는 그룹으로 알람 메시지를 묶는 개념.
            builder.setTicker("Ticker")         // android 4.1부터는 ticker이 표시되지 않음
            builder.setNumber(100)              // android 4.1부터는 number 또한 표시되지 않음
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title2")
            builder.setContentText("Content Text2")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(20, notification)    // 알람을 구분하기 위한 id값.
        }

        btn3.setOnClickListener {
//            var builder = NotificationCompat.Builder(this)
            var builder = getNotificationBuilder("channel2", "another channel")       // android 8.0부터는 notification channal이라는 기능이 생김. 한 채널이라는 그룹으로 알람 메시지를 묶는 개념.
            builder.setTicker("Ticker")         // android 4.1부터는 ticker이 표시되지 않음
            builder.setNumber(100)              // android 4.1부터는 number 또한 표시되지 않음
            builder.setSmallIcon(android.R.drawable.ic_menu_search)
            builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
            builder.setAutoCancel(true)
            builder.setContentTitle("Content Title3")
            builder.setContentText("Content Text3")

            var notification = builder.build()

            var mng = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            mng.notify(30, notification)    // 알람을 구분하기 위한 id값.
        }


    }

    fun getNotificationBuilder(id: String, name: String) : NotificationCompat.Builder {
        var builder: NotificationCompat.Builder? = null

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {     // android 8.0 OREO
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)       // IMPORTANCE에 따라 중요도가 나뉨.
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)

            manager.createNotificationChannel(channel)

            builder = NotificationCompat.Builder(this, id)
        } else {
            builder = NotificationCompat.Builder(this)
        }
        return builder
    }
}
