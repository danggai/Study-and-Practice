package com.example.basicactivityexample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btn1.setOnClickListener {
            setResult(Activity.RESULT_OK)
            finish()
        }

        btn2.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btn99.setOnClickListener {
            finish()
        }
    }
}
