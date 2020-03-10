package com.example.rvtest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rvvp.*

class RVVPActivity : AppCompatActivity() {

    private val itemList1 : MutableList<RVVPPagerAdapter.vpItem> = mutableListOf(
        RVVPPagerAdapter.vpItem("dd","dd", "dd"),
        RVVPPagerAdapter.vpItem("dd","dd", "dd"),
        RVVPPagerAdapter.vpItem("dd","dd", "dd")
    )

    private val initData: MutableList<RVVPAdapter.Data> = mutableListOf(
        RVVPAdapter.Section("pop"),
        RVVPAdapter.ItemList( itemList1 ),
        RVVPAdapter.Section("k-pop"),
        RVVPAdapter.ItemList( itemList1 ),
        RVVPAdapter.Section("etc"),
        RVVPAdapter.ItemList( itemList1 )
    )

    var myData: MutableList<RVVPAdapter.Data> = initData.toMutableList() // copy 같은 역할!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvvp)

        val vpAdapter = RVVPAdapter(myData)

        btn_prev.setOnClickListener {
            val intent = Intent(this, VPActivity::class.java)
            startActivity(intent)
        }

        rv.adapter = vpAdapter
        rv.layoutManager = LinearLayoutManager(this)
//        VP2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }

}