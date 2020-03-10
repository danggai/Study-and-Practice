package com.example.viewpagerexample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val inventoryList: MutableList<Item> = mutableListOf(
        Item("weapon", "Iron Sword", 7, 0, "normal sword."),
        Item("armor", "Leather Armor", 0, 3, "be made of leather."),
        Item("weapon", "Evil Sword", 18, 0, "devil in here."),
        Item("weapon", "Wooden Sword", 4, 1, "a sword made for training purposes"),
        Item("glove", "Work Gloves", 8, 5, "awesome item."),
        Item("boots", "Scale Boots", 2, 15, "boots that made scales."),
        Item("armor", "Scale Armor", 2, 20, "armor that made scales."),
        Item("glove","Mittens", 0, 1, "it's good for keep warm."),
        Item("boots", "Nike Running Shoes", 2,0,"BORN TO RUN")
    )

    class Item(
    var type: String,
    var name: String,
    var atk: Int,
    var def: Int,
    var description: String
    ) { fun getImg(context: Context): Int {
        return context.resources.getIdentifier(type, "drawable", context.packageName)
    }}


override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)      // 구현 대상 뷰페이저의 레이아웃에 초기화.

        val adapter = PagerAdapter(inventoryList)
        inventory.pageMargin = 15       // 아이템 간 간격
        inventory.offscreenPageLimit = 5
        inventory.adapter = adapter
    }

}
