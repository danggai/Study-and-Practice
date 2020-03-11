package com.example.contextmenuexample

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var imgsrc = mutableListOf("blue_curacao", "bombay_sapphire", "captain_morgan", "gordons", "jonnie_red", "jonnie_black", "jose_cuervo", "smirnoff", "triplesec")
    var name = mutableListOf("Blue Curacao", "Bombay Sapphire", "Captain Morgan", "Gordon's", "Jonnie Walker Red Label", "Jonnie Walker Black Label", "Jose Curevo", "Smirnoff", "Triple Sec")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, name)

        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val resource = resources.getIdentifier(imgsrc[position], "drawable", packageName)
            imgView.setImageResource(resource)
        }

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v?.id) {
//            R.id.txtView -> {
//                menu?.setHeaderTitle("Item management")
//                menuInflater.inflate(R.menu.txtview_menu, menu)
//            }
            R.id.listView -> {
                menu?.setHeaderTitle("Item management")
                menuInflater.inflate(R.menu.txtview_menu, menu)
                var info = menuInfo as AdapterView.AdapterContextMenuInfo
                if (info.position % 4 == 0) {
                    menu?.add(Menu.NONE, Menu.FIRST + 99, Menu.NONE, "hidden menu!")
                }
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo

        when(item.itemId) {
            R.id.delete -> {
//                listView.removeView(item)
                Toast.makeText(applicationContext, "delete clicked.", Toast.LENGTH_SHORT).show()
            }
            R.id.dummy1 -> Toast.makeText(applicationContext, "dummy do nothing.", Toast.LENGTH_SHORT).show()
            R.id.dummy2 -> Toast.makeText(applicationContext, "dummy do nothing too.", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}
