package com.example.viewpagerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.viewpagerexample.MainActivity.Item
import kotlinx.android.synthetic.main.page_main.view.*

class PagerAdapter(private val list: MutableList<Item>): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val view = inflater.inflate(R.layout.page_main, container, false)   // 구현 대상 아이템의 레이아웃에 초기화.

        view.image.setImageResource(list[position].getImg(container.context))   // Item 구현 할 때 만들어둔 getImg 함수로 리소스의 위치를 참조.
                        // getImg에서 리소스 번호 확인 -> layout의 page_main.xml에 id="image"인 이미지 뷰에 ImageResource 할당.
        view.name.text = list[position].name
        view.atk.text = list[position].atk.toString()
        view.def.text = list[position].def.toString()
        view.description.text = list[position].description

        container.addView(view)
        return view
    }

    override fun getPageWidth(position: Int): Float {       // 한 화면에 여러 개 찍기
        return 0.33f
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return list.size
    }

}