package com.example.popupmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener { view ->
            var pop = PopupMenu(this, txtView)      // 메뉴를 txtView에 팝업시킴.

            menuInflater.inflate(R.menu.popup_menu, pop.menu)

//            var listener = PopupListener()
//            pop.setOnMenuItemClickListener (listener)              // 오버라이딩 클래스 정의

            pop.setOnMenuItemClickListener { item ->      // 람다 식 이용
                when(item.itemId) {
                    R.id.menu1 -> Toast.makeText(applicationContext, "menu1 clicked.", Toast.LENGTH_SHORT).show()
                    R.id.menu2 -> Toast.makeText(applicationContext, "menu2 clicked.", Toast.LENGTH_SHORT).show()
                }
                false
            }
            pop.show()
        }
    }

    inner class PopupListener: PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(item: MenuItem?): Boolean {
            when (item?.itemId) {
                R.id.menu1 -> Toast.makeText(applicationContext, "menu1 clicked.", Toast.LENGTH_SHORT).show()
                R.id.menu2 -> Toast.makeText(applicationContext, "menu2 clicked.", Toast.LENGTH_SHORT).show()
            }
            return false
        }
    }
}
