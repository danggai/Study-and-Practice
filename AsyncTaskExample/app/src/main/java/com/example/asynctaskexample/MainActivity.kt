package com.example.asynctaskexample

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var time = System.currentTimeMillis()
            txtView1.text= "현재 시각: $time"
            var sync = AsyncTaskClass()
            sync.execute(10, 20)
        }

//        var sync = AsyncTaskClass()
//        sync.execute(10, 20)
    }

    inner class AsyncTaskClass: AsyncTask<Int, Long, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            txtView2.text = "AsyncTask Started."
        }

        override fun doInBackground(vararg params: Int?): String {
            var a1 = params[0]!!
            var a2 = params[1]!!

            for (idx in 0..20) {
                SystemClock.sleep(50)
                a1++
                a2++
                Log.d("async", "$a1, $a2")

                var time = System.currentTimeMillis()
                publishProgress(time)
            }
            return "some string"
        }

        override fun onProgressUpdate(vararg values: Long?) {
            super.onProgressUpdate(*values)
            txtView2.text = "Async: ${values[0]}"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            txtView2.append("\ndone.")
        }
    }
}
