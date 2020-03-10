package com.example.customlistviewexample

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.customlistviewexample.MainActivity.Game
import kotlinx.android.synthetic.main.custom_row.view.*

class MainAdapter(val context: Context, val itemList: MutableList<Game>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.name
        val thumbnail: ImageView = itemView.thumbnail
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.thumbnail.setImageResource(itemList[position].getImg(context))
    }

    override fun getItemCount(): Int = itemList.size
}