package com.example.actionbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        var search_item:MenuItem? = menu?.findItem(R.id.item_search)
        var search_view:SearchView = search_item?.actionView as SearchView

        search_view.queryHint = "keyword...."

        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                txtView1.text = newText
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                txtView2.text = query
                return false
            }
        })

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_normal -> Toast.makeText(this, "but not thing happened..", Toast.LENGTH_SHORT).show()
            R.id.item_top -> Toast.makeText(this, "I'm top ", Toast.LENGTH_SHORT).show()
            R.id.item_middle -> Toast.makeText(this, "in mid", Toast.LENGTH_SHORT).show()
            R.id.item_bottom -> Toast.makeText(this, "I'm ADC", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
