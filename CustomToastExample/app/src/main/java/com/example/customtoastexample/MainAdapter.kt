package com.example.customtoastexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_toast.view.*
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter(val context: Context, private val items: MutableList<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater    // 레이아웃 인플래터 구현

    class Item(val name: String, val type: String, val alcohol: Double, val imgsrc: String)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false))
    }

    class ViewHolder(item : View): RecyclerView.ViewHolder(item) {
        val name: TextView = item.name
        val type: TextView = item.type
        val alcohol: TextView = item.alcohol
        val imgsrc: ImageView = item.image
}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val imageResource = context.getResources().getIdentifier(items[position].imgsrc, "drawable", context.getPackageName())

        holder.itemView.setOnClickListener {
            val toast = Toast(context)                                          // toast 선언
            toast.view = mInflater.inflate(R.layout.custom_toast, null)    // custom Toast 그려내고, 연동.
            toast.view.txtView.text = items[position].name                      // 변수 할당
            toast.view.imgView.setImageResource(imageResource)

            toast.show()
        }

        val item = holder as ViewHolder
        item.name.text = items[position].name
        item.type.text = items[position].type
        item.alcohol.text = items[position].alcohol.toString()
        item.imgsrc.setImageResource(imageResource)
    }

    override fun getItemCount(): Int = items.size
}