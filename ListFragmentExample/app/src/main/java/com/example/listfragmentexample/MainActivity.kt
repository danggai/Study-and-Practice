package com.example.listfragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list_fragment = TestListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container, list_fragment)
            tran.addToBackStack(null)
            tran.commit()
        }

        btn2.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            tran.remove(list_fragment).commit()
        }
    }
}
