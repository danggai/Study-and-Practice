package com.example.broadcastreceiverexample2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
//            var intent = Intent("com.test.br1")     // 안드로이드 8.0 이후로 실행 불가능해짐
            intent.putExtra("from", "BroadcastReceiver Example2")
            intent.setClassName("com.example.broadcastreceiverexample1", "com.example.broadcastreceiverexample1.TestReceiver")
            sendBroadcast(intent)
        }
    }
}
