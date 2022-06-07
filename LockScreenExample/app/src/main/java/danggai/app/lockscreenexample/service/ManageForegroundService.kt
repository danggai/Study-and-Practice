package danggai.app.lockscreenexample.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import danggai.app.lockscreenexample.Constant
import danggai.app.lockscreenexample.R
import danggai.app.lockscreenexample.util.log
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


class ManageForegroundService() : Service() {

    companion object {
        private const val prefix = "foreground.manage."
        const val INIT_FOREGROUND = prefix + "initforeground"
        const val START_FOREGROUND = prefix + "startforeground"
        const val STOP_FOREGROUND = prefix + "stopforeground"
        const val RENEW_FOREGROUND = prefix + "renewforeground"

        fun initService(context: Context) {
            val intent = Intent(context, ManageForegroundService::class.java)
            intent.action = INIT_FOREGROUND

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        fun startService(context: Context) {
            val intent = Intent(context, ManageForegroundService::class.java)
            intent.action = START_FOREGROUND

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(intent)
            } else {
                context.startService(intent)
            }
        }

        fun stopService(context: Context) {
            val intent = Intent(context, ManageForegroundService::class.java)
            intent.action = STOP_FOREGROUND

            context.stopService(intent)
        }
    }

    private val compositeDisposable = CompositeDisposable()
    private fun Disposable.addCompositeDisposable() {
        compositeDisposable.add(this)
    }

    private lateinit var onTopView: View
    private lateinit var manager: WindowManager

    private var iconNotification: Bitmap? = null
    private var notification: Notification? = null
    private val mNotificationId = 123

    var mNotificationManager: NotificationManager? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            INIT_FOREGROUND -> {
                log.e("Init Foreground intent received")

                try {
                    manager.removeView((getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.lock_screen_overlay, null))
                } catch(e:Exception) { }

//                LockScreenActivity.startActivity(applicationContext)
                createOverlayActivity()
                generateForegroundNotification(applicationContext.getString(R.string.foreground_service_title_init), "")
            }
            START_FOREGROUND -> {
                log.e("Start Foreground intent received")
                generateForegroundNotification(String.format(applicationContext.getString(R.string.foreground_service_using_title), "김다날"), getString(R.string.foreground_service_using_msg))
            }
            STOP_FOREGROUND -> {
                log.e("Stop Foreground intent received")
//                LockScreenActivity.startActivity(applicationContext)
                stopForegroundService()
            }
            RENEW_FOREGROUND -> {
                log.e("Renew Foreground intent received")
//                createOverlayActivity()
            }

        }
        return START_NOT_STICKY
    }

    private fun sendNoti(id: Int) {
        log.e()

        val title = "인증 만료 안내"
        val msg = "5분 후 사용 시간이 만료됩니다."

        val notificationId = "NOTIFICATION_ID"
        val notificationDesc = "NOTIFICATION_DESC"

        val notificationManager: NotificationManager = ContextCompat.getSystemService(
            applicationContext,
            NotificationManager::class.java
        ) ?: return

        val builder = NotificationCompat.Builder(applicationContext, notificationId)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(msg)
            .setAutoCancel(true)
            .setStyle(NotificationCompat.BigTextStyle().bigText(msg))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(notificationId, title, NotificationManager.IMPORTANCE_DEFAULT).apply {
                    description = notificationDesc
                }
            )
        }

        notificationManager.notify(id, builder.build())
    }

    private fun generateForegroundNotification(title: String, msg: String) {

            iconNotification = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            if (mNotificationManager == null) {
                mNotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                assert(mNotificationManager != null)
                val notificationChannel =
                    NotificationChannel(
                        Constant.FOREGROUND_SERVICE_ID, Constant.FOREGROUND_SERVICE_NAME,
                        NotificationManager.IMPORTANCE_MIN)
                notificationChannel.enableLights(false)
                notificationChannel.lockscreenVisibility = Notification.VISIBILITY_SECRET
                mNotificationManager?.createNotificationChannel(notificationChannel)
            }

            val stopIntent = Intent(applicationContext, ManageForegroundService::class.java)
            stopIntent.action = INIT_FOREGROUND
            val stopPendingIntent = PendingIntent
                .getService(applicationContext, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE)

            val renewalIntent = Intent(applicationContext, ManageForegroundService::class.java)
            renewalIntent.action = RENEW_FOREGROUND
            val renewPendingIntent = PendingIntent
                .getService(applicationContext, 1, renewalIntent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationCompat.Builder(this, Constant.FOREGROUND_SERVICE_ID)

            builder.setContentTitle(title)
                .setTicker(title)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setWhen(0)
                .setOnlyAlertOnce(false)
                .setOngoing(true)
                .addAction(NotificationCompat.Action(0, "사용 종료", stopPendingIntent))
                .addAction(NotificationCompat.Action(0, "시간 갱신", renewPendingIntent))

            if (msg.isNotBlank()) builder.setContentText(msg)

            if (iconNotification != null) {
                builder.setLargeIcon(Bitmap.createScaledBitmap(iconNotification!!, 128, 128, false))
            }
            notification = builder.build()
            startForeground(mNotificationId, notification)

    }

    fun createOverlayActivity() {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        onTopView = inflater.inflate(R.layout.lock_screen_overlay, null).apply {
            this.findViewById<Button>(R.id.btn_unlock)?.setOnClickListener {
                ManageForegroundService.startService(context)
                manager?.removeView(this)
            }
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY } else { WindowManager.LayoutParams.TYPE_PHONE },
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                    WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or
                    WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN,
            PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.LEFT or Gravity.TOP
        manager = getSystemService(WINDOW_SERVICE) as WindowManager

        manager.addView(onTopView, params)

    }

    override fun onBind(intent: Intent?): IBinder? {
        log.e()
        return null
    }

    override fun onDestroy() {
        stopForeground(true)
    }

    private fun stopForegroundService() {
        stopForeground(true)
        stopSelf()
    }
}