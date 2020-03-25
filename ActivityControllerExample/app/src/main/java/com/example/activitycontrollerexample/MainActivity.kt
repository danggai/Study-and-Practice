package com.example.activitycontrollerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var text1: String? = null
    var text2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(INPUT_FRAGMENT)
    }

    fun setFragment(name: Int) {
        var tran = supportFragmentManager.beginTransaction()
        when(name){
            INPUT_FRAGMENT -> {
                tran.replace(R.id.mainFrame, InputFragment())
            }
            RESULT_FRAGMENT -> {
                tran.replace(R.id.mainFrame, ResultFragment())
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }

    val INPUT_FRAGMENT = 1
    val RESULT_FRAGMENT = 2

}

