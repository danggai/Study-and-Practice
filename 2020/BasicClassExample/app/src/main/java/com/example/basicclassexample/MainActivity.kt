package com.example.basicclassexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var t1 = TestClass()
            t1.data10 = 100
            t1.data20 = "안뇽 나는 메인문자열"

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("test1", t1)

            startActivityForResult(intent, 201)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK) {
            var t2 = data?.getParcelableExtra<TestClass>("test2")
            txtView2.text = "t2.data10 = ${t2?.data10}\n"
            txtView2.append("t2.data20 = ${t2?.data20}")
        }
    }
}
