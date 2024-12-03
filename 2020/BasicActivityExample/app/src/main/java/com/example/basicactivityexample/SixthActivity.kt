package com.example.basicactivityexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicactivityexample.R
import com.example.basicactivityexample.TestClass
import kotlinx.android.synthetic.main.activity_second.*

class SixthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sixth)

        var t1 = intent.getParcelableExtra<TestClass>("test1")

        txtView2.text = "t1.data10: ${t1.data10}"
        txtView2.append("\nt1.data20: ${t1.data20}")

        btn1.setOnClickListener { view ->
            var t2 = TestClass()
            t2.data10 = 200
            t2.data20 = "나는 세컨드 문자열이얌"

            var intent2 = Intent()
            intent2.putExtra("test2", t2)
            setResult(Activity.RESULT_OK, intent2)
            finish()
        }
    }
}
