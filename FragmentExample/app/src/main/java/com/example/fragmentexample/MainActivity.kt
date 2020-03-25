package com.example.fragmentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            //tran.add(R.id.frame1, FirstFragment())      // 이 방법으로 하면 두 프래그먼트가 겹치며, 두 번 누르면 충돌.
            tran.replace(R.id.frame1, FirstFragment())      // 기존 프래그먼트는 제거됨.
            tran.addToBackStack(null)
            tran.commit()
        }
        btn2.setOnClickListener {
            var tran = supportFragmentManager.beginTransaction()
            // tran.add(R.id.frame1, SecondFragment())      // 이 방법으로 하면 두 프래그먼트가 겹치며, 두 번 누르면 충돌.
            tran.replace(R.id.frame1, SecondFragment())      // 기존 프래그먼트는 제거됨.
            tran.addToBackStack(null)
            tran.commit()
        }
    }

    override fun onBackPressed() {
        Toast.makeText(this, "you pressed back btn.", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }
}
