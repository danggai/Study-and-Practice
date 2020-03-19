package com.example.anotherappintent1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var from = intent.getStringExtra("from")
        txtView1.append("\n${from}에서 왔당!")

        btn1.setOnClickListener {
            var intent = Intent()
            intent.putExtra("from", "intent app1")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
