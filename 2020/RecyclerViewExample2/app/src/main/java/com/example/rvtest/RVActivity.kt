package com.example.rvtest

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rv.*


class RVActivity : AppCompatActivity() {

    private val initData: MutableList<RVAdapter.Data> = mutableListOf(
        RVAdapter.Section("pop"),
        RVAdapter.Song("Halo", "Beyonce"),
        RVAdapter.Song("Bohemian Rhapsody", "Queen"),
        RVAdapter.Song("24K magic", "Bruno Mars"),
        RVAdapter.Song("Warrior", "Imagine Dragons"),
        RVAdapter.Song("Believer", "Imagine Dragons"),
        RVAdapter.Song("City of Stars", "Ryan Gosling, Emma Stone"),
        RVAdapter.Section("k-pop"),
        RVAdapter.Song("Mali Flower", "Sungchul Lee"),
        RVAdapter.Song("Daddy", "PSY"),
        RVAdapter.Song("Champion", "PSY"),
        RVAdapter.Section("etc"),
        RVAdapter.Song("Kimchi", "?"),
        RVAdapter.Song("bibimbob", "Yummy"),
        RVAdapter.Song("MAMAAAAAaaaa", "WOOOOOOooooo~"),
        RVAdapter.Song("Digital Camera", "inside")
    )

    var myData: MutableList<RVAdapter.Data> = initData.toMutableList() // copy 같은 역할!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        val mAdapter = RVAdapter(myData)

        try {
            this.supportActionBar!!.hide()
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        } catch (e: NullPointerException) {
        }

        btn_next.setOnClickListener {
            val intent = Intent(this, VPActivity::class.java)
            startActivity(intent)
        }

        menu_btn_init.setOnClickListener {
            myData.clear()
            myData.addAll(initData)
            mAdapter.notifyDataSetChanged()

            Toast.makeText(applicationContext, "init clicked", Toast.LENGTH_SHORT).show()
        }

        menu_btn_song.setOnClickListener {
            val new = RVAdapter.Song("New Song", "Various Artist")
            myData.add(new)
            mAdapter.notifyDataSetChanged()
//            myData.add(0,new)
//            mAdapter.notifyItemInserted(0);  // 리스트 앞에 추가하기!

            Toast.makeText(applicationContext, "Add Song clicked", Toast.LENGTH_SHORT).show()
        }

        menu_btn_section.setOnClickListener {
            myData.add(RVAdapter.Section("New Section"))
            Toast.makeText(applicationContext, "Add Section clicked", Toast.LENGTH_SHORT).show()
        }

        rv.adapter = mAdapter
        rv.layoutManager = LinearLayoutManager(this)
    }
}

