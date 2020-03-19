package com.example.anotherappintentexample

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var permission_list = arrayOf(
        Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        btn1.setOnClickListener {
            var intent = Intent("com.test.intentApp")

            intent.putExtra("from", "Main Example")
            startActivityForResult(intent, 1)
        }

        btn2.setOnClickListener {
            var uri = Uri.parse("geo:37.243243, 131.861601")
            var intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        btn3.setOnClickListener {
            var uri = Uri.parse("https://developer.android.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)

            startActivity(intent)
        }

        btn4.setOnClickListener {
            var uri = Uri.parse("tel:01011111111")
            var intent = Intent(Intent.ACTION_DIAL, uri)

            startActivity(intent)
        }

        btn5.setOnClickListener {
            var uri = Uri.parse("tel:01011111111")
            var intent = Intent(Intent.ACTION_CALL, uri)

            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            var from = data?.getStringExtra("from")
            txtView1.append("\n${from}에서 돌아옴.")
        }
    }

    fun checkPermission() {
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        for(permission: String in permission_list) {
            var chk = checkCallingOrSelfPermission(permission)

            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permission_list, 0)
                break
            }
        }
    }
}
