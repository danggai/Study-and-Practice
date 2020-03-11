package com.example.customadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var imgsrc = mutableListOf("blue_curacao", "bombay_sapphire", "captain_morgan", "gordons", "jonnie_red", "jonnie_black")
    var datas = mutableListOf("Blue Curacao", "Bombay Sapphire", "Captain Morgan", "Gordon's", "Jonnie Walker Red Label", "Jonnie Walker Black Label")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ListAdapter()
        customList.adapter = adapter
    }

    inner class ListAdapter: BaseAdapter() {

        private var btnListener = BtnListener()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {     // 중-요함! 항목 '하나'를 구성하기 위한 메소드.
            var view: View? = convertView

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.list_item, parent, false)
            }

            val image1: ImageView? = view?.findViewById(R.id.image1)
            val imageResource = parent!!.context.getResources().getIdentifier(imgsrc[position], "drawable", parent.context.getPackageName());
            val text1: TextView? = view?.findViewById(R.id.text1)
            val btn1: Button? = view?.findViewById(R.id.btn1)
            val btn2: Button? = view?.findViewById(R.id.btn2)

            image1?.setImageResource( imageResource )
            text1?.text = datas[position]
            btn1?.setOnClickListener( btnListener )
            btn2?.setOnClickListener( btnListener )

            btn1?.tag = datas[position]        // 태그를 이용해서, 해당 뷰에 추가적인 값 할당/전달 가능
            btn2?.tag = datas[position]

            return view
        }


        override fun getItem(position: Int): Any? = null      // 필요 없어서 null로 fix.

        override fun getItemId(position: Int): Long = 0       // 항복을 대표하는 id값

        override fun getCount(): Int = datas.size
    }

    inner class BtnListener :View.OnClickListener {
        override fun onClick(v: View?) {
            var data = v?.tag as String

            when(v?.id) {
                R.id.btn1 -> selected.text = "Selected ${data} half bottle"
                R.id.btn2 -> selected.text = "Selected ${data} full bottle"
            }
        }
    }
}
