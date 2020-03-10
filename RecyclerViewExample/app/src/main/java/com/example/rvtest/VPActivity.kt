package com.example.rvtest

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_vp.*

class VPActivity : AppCompatActivity() {

    private val initData: MutableList<VPAdapter.Data> = mutableListOf(
        VPAdapter.Section("pop"),
        VPAdapter.Song("Halo", "Beyonce"),
        VPAdapter.Song("Bohemian Rhapsody", "Queen"),
        VPAdapter.Song("24K magic", "Bruno Mars"),
        VPAdapter.Song("Warrior", "Imagine Dragons"),
        VPAdapter.Song("Believer", "Imagine Dragons"),
        VPAdapter.Song("City of Stars", "Ryan Gosling, Emma Stone"),
        VPAdapter.Section("k-pop"),
        VPAdapter.Song("Mali Flower", "Sungchul Lee"),
        VPAdapter.Song("Daddy", "PSY"),
        VPAdapter.Song("Champion", "PSY"),
        VPAdapter.Section("etc"),
        VPAdapter.Song("Kimchi", "?"),
        VPAdapter.Song("bibimbob", "Yummy"),
        VPAdapter.Song("MAMAAAAAaaaa", "WOOOOOOooooo~"),
        VPAdapter.Song("Digital Camera", "inside")
    )

    var myData: MutableList<VPAdapter.Data> = initData.toMutableList() // copy 같은 역할!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp)

        val vpAdapter = VPAdapter(myData)

        try {
            this.supportActionBar!!.hide()
            getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        } catch (e: NullPointerException) {
        }

        btn_prev.setOnClickListener {
            val intent = Intent(this, RVActivity::class.java)
            startActivity(intent)
        }

        btn_next.setOnClickListener {
            val intent = Intent(this, RVVPActivity::class.java)
            startActivity(intent)
        }

//        menu_btn_init.setOnClickListener {
//            myData.clear()
//            myData.addAll(initData)
//            mAdapter.notifyDataSetChanged()
//
//            Toast.makeText(applicationContext, "init clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        menu_btn_song.setOnClickListener {
//            val new = RVAdapter.Song("New Song", "Various Artist")
//            myData.add(new)
//            mAdapter.notifyDataSetChanged()
////            myData.add(0,new)
////            mAdapter.notifyItemInserted(0);  // 리스트 앞에 추가하기!
//
//            Toast.makeText(applicationContext, "Add Song clicked", Toast.LENGTH_SHORT).show()
//        }
//
//        menu_btn_section.setOnClickListener {
//            myData.add(RVAdapter.Section("New Section"))
//            Toast.makeText(applicationContext, "Add Section clicked", Toast.LENGTH_SHORT).show()
//        }

        vp1.adapter = vpAdapter
        vp1.orientation = ViewPager2.ORIENTATION_VERTICAL
        vp2.adapter = vpAdapter
        vp2.orientation = ViewPager2.ORIENTATION_VERTICAL
        vp3.adapter = vpAdapter
        vp3.orientation = ViewPager2.ORIENTATION_VERTICAL
    }
}

