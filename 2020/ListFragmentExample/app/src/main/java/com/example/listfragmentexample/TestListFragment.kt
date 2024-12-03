package com.example.listfragmentexample

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.ListFragment

/**
 * A simple [Fragment] subclass.
 */
class TestListFragment : ListFragment() {

    var txtView: TextView?= null
    var list = arrayOf("item1", "item2", "item3", "item4", "item5")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_test_list, container, false)

        txtView = view.findViewById(R.id.txtView1)
        var adapter = ArrayAdapter (
            activity as Context , android.R.layout.simple_list_item_1, list
        )

        listAdapter = adapter

        return view
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        Toast.makeText(context, "you clicked ${list[position]}.", Toast.LENGTH_SHORT).show()
    }
}
