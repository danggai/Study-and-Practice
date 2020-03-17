package com.example.asynctaskexample

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            txtView1.text= "현재 시각: $time"
        }

        var sync = AsyncTaskClass()
        sync.execute(10, 20)
    }

    inner class AsyncTaskClass: AsyncTask<Int, Long, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            txtView2.text = "AsyncTask Started."
        }

        override fun doInBackground(vararg params: Int?): String {
            return "some string"
        }
    }
}
