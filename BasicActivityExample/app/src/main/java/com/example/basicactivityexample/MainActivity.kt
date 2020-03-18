package com.example.basicactivityexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener { view ->
            var intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, 203)
        }

        btn3.setOnClickListener { view ->
            var intent = Intent(this, FourthActivity::class.java)
            startActivityForResult(intent, 204)
        }

        btn4.setOnClickListener { view ->
            var intent = Intent(this, FifthActivity::class.java)

            intent.putExtra("data1", 111)
            intent.putExtra("data2", 11.1)
            intent.putExtra("data3", true)
            intent.putExtra("data4", "I seoul you")

            startActivityForResult(intent, 205)
        }

        btn5.setOnClickListener { view ->
            var t1 = TestClass()
            t1.data10 = 100
            t1.data20 = "안뇽 나는 메인문자열"

            var intent = Intent(this, SixthActivity::class.java)

            intent.putExtra("test1", t1)

            startActivityForResult(intent, 206)
        }

        btn99.setOnClickListener { view ->
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {       // startActivityForResult에서만 발생함.
        super.onActivityResult(requestCode, resultCode, data)
//        Log.d("test", "onActivityResult activated.")
        when(requestCode) {     // startActivityForResult의 값을 그대로 받아옴.
            203 -> txtView1.text = "you came from THIRD Activity, sure?"
            204 -> txtView1.text = "you came from FOURTH Activity, sure?"
            205 -> {        // intent로 setResult로 값을 담아 보낸 경우, data로 전달 됨.
                val value1 = data?.getIntExtra("value1", 0)
                val value2 = data?.getDoubleExtra("value2", 0.0)
                val value3 = data?.getBooleanExtra("value3", false)
                val value4 = data?.getStringExtra("value4")
                txtView1.text = "${value1} / ${value2} / ${value3} / ${value4}"
            }
            206 -> {
                if(resultCode == Activity.RESULT_OK) {
                    var t2 = data?.getParcelableExtra<TestClass>("test2")
                    txtView1.text = "t2.data10 = ${t2?.data10}\n"
                    txtView1.append("t2.data20 = ${t2?.data20}")
                }
            }
            else -> txtView1.text = "Hmm, I'm not sure about that."
        }
        when(resultCode) {
            Activity.RESULT_OK -> txtView1.append("\nand well done.")
            Activity.RESULT_CANCELED -> txtView1.append("\nbut you have to do again.")
        }
    }
}
