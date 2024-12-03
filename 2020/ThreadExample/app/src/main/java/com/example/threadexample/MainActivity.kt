package com.example.threadexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import androidx.annotation.UiThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var now = System.currentTimeMillis()
            txtView1.text = "현재 시간: $now"
        }

        isRunning = true
        var thread = ThreadClass1()
        thread.start()
    }

    inner class ThreadClass1: Thread() {
        override fun run() {
            while (isRunning) {
                var now = System.currentTimeMillis()
//                txtView2.text = now.toString()        // 이런 방식으로 작성 시 오류 발생
                runOnUiThread(
                    Runnable {
//                        Log.d("log", "uithread running?")
                        txtView2.text = "현재 시간: $now"
                    }
                )
                SystemClock.sleep(100)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}
