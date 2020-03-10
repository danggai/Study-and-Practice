package com.example.rvtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rvtest.RVVPPagerAdapter.vpItem
import kotlinx.android.synthetic.main.activity_rv_section.view.item_name
import kotlinx.android.synthetic.main.activity_rvvp_pager_item.view.*

class RVVPAdapter(private val items: MutableList<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Data          // 두 데이터중 하나가 등장Data
    class Section(val name: String) : Data
    class ItemList(val item: MutableList<vpItem>) : Data

    override fun getItemViewType(position: Int): Int =
        when (items[position]) {
            is Section -> TYPE_SECTION
            is ItemList -> TYPE_ITEMLIST
            else -> throw IllegalArgumentException()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType) {
        TYPE_ITEMLIST -> ItemListHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rvvp_pager, parent, false))
        TYPE_SECTION -> SectionViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rvvp_section, parent, false))
        else -> throw IllegalArgumentException()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            TYPE_ITEMLIST -> onBindItemList(holder, items[position] as MutableList<vpItem> )
            TYPE_SECTION -> onBindSection(holder, items[position] as Section)
            else -> throw IllegalArgumentException()
        }

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvSection: TextView = itemView.item_name
    }
    private fun onBindSection(holder: RecyclerView.ViewHolder, item: Section) {
        val section = holder as SectionViewHolder
        section.rvSection.text = item.name
    }

    class ItemListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vpGenre: TextView = itemView.item_genre
        val vpName : TextView = itemView.item_name
//        val vpDesc: TextView = itemView.item_description
    }
    private fun onBindItemList(holder: RecyclerView.ViewHolder, items: MutableList<vpItem>) {
        val vp = holder as ItemListHolder
        RVVPPagerAdapter(items)
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val vpGenre: TextView = itemView.item_genre
        val vpName : TextView = itemView.item_name
    }



    companion object {
        private const val TYPE_SECTION = 1
        private const val TYPE_ITEMLIST = 2
    }
}
