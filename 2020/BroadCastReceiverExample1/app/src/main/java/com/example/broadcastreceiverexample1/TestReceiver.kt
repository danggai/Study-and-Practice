package com.example.broadcastreceiverexample1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class TestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var from = intent.getStringExtra("from")

        Toast.makeText(context,"Brocdcast Receiver activated in receiver exam1.\nIt called from ${from}", Toast.LENGTH_SHORT).show()
    }
}
