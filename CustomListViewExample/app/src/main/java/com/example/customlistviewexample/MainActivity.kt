package com.example.customlistviewexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var games : MutableList<Game> = mutableListOf(
        Game("Diablo IV","diablo4"),
        Game("HearthStone", "hearthstone"),
        Game("Heroes of the Storm","hots"),
        Game("Overwatch","overwatch"),
        Game("StarCraft","starcraft"),
        Game("StarCraft Remastered", "scre"),
        Game("StarCraft2", "starcraft2"),
        Game("World of Warcraft", "wow")
    )

    class Game(
        var name: String,
        var imgsrc: String
    ) { fun getImg(context: Context): Int = context.resources.getIdentifier(imgsrc, "drawable", context.packageName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainAdapter(this, games)
        RV.adapter = adapter
        RV.layoutManager = LinearLayoutManager(this)
    }
}
