package com.example.spinnerexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imgsrc = mutableListOf("blue_curacao", "bombay_sapphire", "captain_morgan", "gordons", "jonnie_red", "jonnie_black", "jose_cuervo", "smirnoff", "triplesec")
    var name = mutableListOf("Blue Curacao", "Bombay Sapphire", "Captain Morgan", "Gordon's", "Jonnie Walker Red Label", "Jonnie Walker Black Label", "Jose Curevo", "Smirnoff", "Triple Sec")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, name)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = SpinnerListener()
    }

    inner class SpinnerListener : AdapterView.OnItemSelectedListener {

        override fun onNothingSelected(parent: AdapterView<*>?) {}  // not happened.

        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val imageResource = parent!!.context.getResources().getIdentifier(imgsrc[position], "drawable", parent.context.getPackageName())
            txtView.text = name[position]
            imgView.setImageResource(imageResource)
            txtView.visibility = View.GONE
        }


    }
}
