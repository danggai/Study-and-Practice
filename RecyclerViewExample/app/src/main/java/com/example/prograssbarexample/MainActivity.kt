package com.example.prograssbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_in.setOnClickListener {
            progress_horizontal.incrementProgressBy(5)
        }

        btn_de.setOnClickListener {
            progress_horizontal.incrementProgressBy(-5)
        }

        btn_set.setOnClickListener {
            progress_horizontal.progress = 50
        }
    }
}
