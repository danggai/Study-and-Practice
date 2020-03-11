package com.example.optionmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {    // 메뉴 만들기 쌉가능
        menuInflater.inflate(R.menu.option_menu, menu)

        menu?.add(Menu.NONE, Menu.FIRST+1, Menu.NONE, "code menu1")  // 코트로 메뉴 구현하기
        menu?.add(Menu.NONE, Menu.FIRST+2, Menu.NONE, "code menu2")
        var sub:Menu? = menu?.addSubMenu("code menu3")
        sub?.add(Menu.NONE, Menu.FIRST+3, Menu.NONE, "code menu3-1")
        sub?.add(Menu.NONE, Menu.FIRST+4, Menu.NONE, "code menu3-2")

        return true     // false를 return하면 메뉴가 숨음.
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu1 -> txtView.text = "you selected menu1"
            R.id.menu3 -> txtView.text = "you selected menu3"
            R.id.menu2_1 -> txtView.text = "you selected menu2-1"
            R.id.menu2_2 -> txtView.text = "you selected menu2-2"
            R.id.menu2_3 -> txtView.text = "you selected menu2-3"
            /*  위는 xml로 구현한 메뉴, 아래는 액티비티에서 코드로 구현한 메뉴.  */
            Menu.FIRST + 1 -> txtView.text = "you selected code menu1"
            Menu.FIRST + 2 -> txtView.text = "you selected code menu2"
            Menu.FIRST + 3 -> txtView.text = "you selected code menu3-1"
            Menu.FIRST + 4 -> txtView.text = "you selected code menu3-2"
        }
        return super.onOptionsItemSelected(item)
    }
}
