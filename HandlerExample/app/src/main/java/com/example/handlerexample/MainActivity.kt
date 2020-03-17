package com.example.handlerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import android.view.Display
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var handler: DisplayHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            txtView1.text = time.toString()
        }

        handler = DisplayHandler()
        var thread = ThreadClass()

        handler?.post(thread)           // post로 호출 시, android method가 한가할 때 호출함. 단 1번 실행
    }

    inner class ThreadClass: Thread() {
        var a1 = 10
        var a2 = 20

        override fun run() {
            var time = System.currentTimeMillis()
            txtView2.text = "Thread: $time"     // 안드 8.0 미만에서는 에러 발생.

//            var msg = Message()
//            msg.what = 0
//            msg.obj = time
//            handler?.sendMessage(msg)

            var msg2 = Message()
            msg2.what = 1
            msg2.arg1 = ++a1
            msg2.arg2 = ++a2
            msg2.obj = "object"
            handler?.sendMessage(msg2)

//            handler?.post(this)     // 종료 시 핸드러에 자기 자신을 다시 올리는 수행을 반복함.
            handler?.postDelayed(this, 100) // 100ms 마다
        }
    }

    inner class DisplayHandler: Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            when (msg?.what) {
                0 -> txtView3.text = "Handler: ${msg?.obj}"
                1 -> txtView3.text = "Handler: ${msg?.arg1}, ${msg?.arg2}, ${msg?.obj}"
            }
        }
    }
}
