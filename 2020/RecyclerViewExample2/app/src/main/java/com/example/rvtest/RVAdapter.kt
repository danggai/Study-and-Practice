package com.example.rvtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_rv_section.view.*
import kotlinx.android.synthetic.main.activity_rv_item.view.*

class RVAdapter(private val items: List<Data>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface Data
    class Song(val title: String, val singer: String?) : Data
    class Section(val name: String) : Data

    override fun getItemViewType(position: Int): Int =
        when (items[position]) {
            is Song -> TYPE_SONG
            is Section -> TYPE_SECTION
            else -> throw IllegalArgumentException()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when(viewType) {
        TYPE_SONG -> SongViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rv_item, parent, false))
        TYPE_SECTION -> SectionViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_rv_section, parent, false))
        else -> throw IllegalArgumentException()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        when (holder.itemViewType) {
            TYPE_SONG -> onBindSong(holder, items[position] as Song)
            TYPE_SECTION -> onBindSection(holder, items[position] as Section)
            else -> throw IllegalArgumentException()
        }

    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvTitle: TextView = itemView.item_title
        val rvSinger: TextView = itemView.item_singer
    }
    private fun onBindSong(holder: RecyclerView.ViewHolder, item: Song) {
        val song = holder as SongViewHolder
        song.rvTitle.text = item.title
        song.rvSinger.text = item.singer
    }

    class SectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvSection: TextView = itemView.item_name
    }
    private fun onBindSection(holder: RecyclerView.ViewHolder, item: Section) {
        val song = holder as SectionViewHolder
        song.rvSection.text = item.name
    }

    companion object{
        private const val TYPE_SONG = 1
        private const val TYPE_SECTION = 2
    }
}
