package com.example.customtoastexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.customtoastexample.MainAdapter.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var alcohol : MutableList<Item> = mutableListOf(
        Item("Blue Curacao", "Liqueur",25.0, "blue_curacao"),
        Item("Bombay Sapphire","Gin", 47.3, "bombay_sapphire"),
        Item("Captain Morgan","Rum", 35.0, "captain_morgan"),
        Item("Disaronno","Liqueur", 31.0, "disaronno"),
        Item("Gordon's", "Gin", 43.0, "gordons"),
        Item("Jonnie Walker Black Label","Vodka", 40.0, "jonnie_black"),
        Item("Jonnie Walker Red Label","Vodka", 40.0, "jonnie_red"),
        Item("Jose Cuervo", "Tequila", 38.0,"jose_cuervo"),
        Item("New Amsterdam","Vodka", 40.0, "new_amsterdam"),
        Item("Smirnoff","Vodka", 40.0, "smirnoff"),
        Item("Triple sec", "Liqueur",40.0, "triplesec")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this, alcohol)
        Recyclerview.adapter = adapter
        Recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
