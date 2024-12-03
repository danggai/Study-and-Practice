package com.example.stylenotificationexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "Style Notification")
            builder.setContentTitle("Big Picture")                  // 작은 알람일 때 타이틀
            builder.setContentText("Big Picture Notification")      // 작은 알람일 때 내용
            builder.setSmallIcon(android.R.drawable.ic_menu_delete)

            var big = NotificationCompat.BigPictureStyle(builder)
            big.bigPicture(BitmapFactory.decodeResource(resources, R.drawable.hots))
            big.setBigContentTitle("Big Content Title")             // 큰 알람일 때 타이틀, 없을 시 contentTitle를 공유함.
            big.setSummaryText("Summary Text")                      // 큰 알람일 때 내용

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        btn2.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "Style Notification")
            builder.setContentTitle("Big Text")                  // 작은 알람일 때 타이틀
            builder.setContentText("Big Text Notification")      // 작은 알람일 때 내용
            builder.setSmallIcon(android.R.drawable.ic_menu_delete)

            var big = NotificationCompat.BigTextStyle(builder)
            big.setBigContentTitle("Big Content Title")          // 큰 알람일 때 타이틀, 없을 시 contentTitle를 공유함.
            big.setSummaryText("애국가")                          // 큰 알람일 때 내용 (시간 옆에 뜸)
            big.bigText("동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        btn3.setOnClickListener { view ->
            var builder = getNotificationBuilder("style", "Style Notification")
            builder.setContentTitle("In Box")                  // 작은 알람일 때 타이틀
            builder.setContentText("In Box Notification")      // 작은 알람일 때 내용
            builder.setSmallIcon(android.R.drawable.ic_menu_delete)

            var inbox = NotificationCompat.InboxStyle(builder)      // 한 줄씩 addLine을 통해 추가한다는 점이 bigText와의 차이점
            inbox.setSummaryText("Summary Text")
            inbox.addLine("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
            inbox.addLine("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
            inbox.addLine("ccccccccccccccccccccccccccccccccccccccccccccccccccccc")
            inbox.addLine("ddddddddddddddddddddddddddddddddddddddddddddddddddddd")

            var notification = builder.build()
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }
    }

    fun getNotificationBuilder (id: String, name:String): NotificationCompat.Builder {
        var builder : NotificationCompat.Builder? = null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
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
