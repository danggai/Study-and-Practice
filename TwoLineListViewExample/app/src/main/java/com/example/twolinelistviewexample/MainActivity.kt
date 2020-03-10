package com.example.twolinelistviewexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    class Alcohol (
        val name: String,
        val kind: String,
        val alcohol: String,
        val imgsrc: String
    ) { fun getImg(context: Context): Int = context.resources.getIdentifier(imgsrc, "drawable", context.packageName)
    }

    var alcohol = arrayListOf(
        Alcohol("Smirnoff","Vodka", "40", "smirnoff"),
        Alcohol("Captain Morgan","Rum", "35", "captain"),
        Alcohol("Jose Cuervo", "Tequila", "38","jose"),
        Alcohol("Gordon's", "Jin","43", "gordon"),
        Alcohol("Bombay Sapphire","Jin", "47", "bluebird"),
        Alcohol("Triple sec", "Liqueur","40", "trisec"),
        Alcohol("Blue Curacao", "Liqueur","25", "bluecuracao"),
        Alcohol("New Amsterdam","Vodka", "40", "newam"),
        Alcohol("Disaronno","Liqueur", "31", "disaronno")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list = ArrayList<HashMap<String, String>>()

        var idx = 0
        while (idx < alcohol.size){
            var map = HashMap<String, String>()
            map.put("name", alcohol[idx].name)
            map.put("alcohol", alcohol[idx].kind + " / " +alcohol[idx].alcohol)
            list.add(map)

            idx++
        }

        var key = arrayOf("name", "alcohol")
        var ids = intArrayOf(android.R.id.text1, android.R.id.text2)

        var adapter = SimpleAdapter(this, list, android.R.layout.simple_expandable_list_item_2, key, ids)
        myListView.adapter = adapter

        myListView.setOnItemClickListener { parent, view, position, id ->
            selected.text = alcohol[position].name
        }
    }
}
