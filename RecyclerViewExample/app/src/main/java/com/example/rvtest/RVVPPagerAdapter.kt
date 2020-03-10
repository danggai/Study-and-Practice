package com.example.rvtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_rvvp_pager_item.view.*

class RVVPPagerAdapter(private val items: MutableList<vpItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class vpItem(
        val genre: String,
        val name: String?,
        val description: String?
    )      // 하위 모든 거시기들이 항상 존재함

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.activity_rvvp_pager_item, parent, false)

        return ItemHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        onBindItem(holder, items[position])

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vpGenre: TextView = itemView.item_genre
        val vpName: TextView = itemView.item_name
    }
    private fun onBindItem(holder: RecyclerView.ViewHolder, item: vpItem) {
        val song = holder as ItemHolder
//        song.vpGenre.text = item[position].genre
        song.vpName.text = item.name
    }
}
