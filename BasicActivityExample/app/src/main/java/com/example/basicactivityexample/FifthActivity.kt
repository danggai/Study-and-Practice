package com.example.basicactivityexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fifth.*

class FifthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        var data1 = intent.getIntExtra("data1", 0)
        var data2 = intent.getDoubleExtra("data2", 0.0)
        var data3 = intent.getBooleanExtra("data3", false)
        var data4 = intent.getStringExtra("data4")

        txtView2.text = "${data1} / ${data2} / ${data3} / ${data4}"

        btn1.setOnClickListener {
            var intent= Intent()

            intent.putExtra("value1", 222)
            intent.putExtra("value2", 22.2)
            intent.putExtra("value3", true)
            intent.putExtra("value4", "daegu wu-ruk gwang-uh")

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }


}
