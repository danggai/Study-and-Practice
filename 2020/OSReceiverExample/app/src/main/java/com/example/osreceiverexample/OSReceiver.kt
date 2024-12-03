package com.example.osreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class OSReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action){
//            "android.intent.action.BOOT_COMPLETED" -> {
            Intent.ACTION_BOOT_COMPLETED -> {
                Toast.makeText(context, "Boot Completed.", Toast.LENGTH_SHORT).show()
            }
//            "android.provider.Telephony.SMS_RECEIVED" -> {
            Telephony.Sms.Intents.SMS_RECEIVED_ACTION -> {
                Log.e("msg", "문자왔살법")
                var str = ""
                var bundle = intent.extras
                if (bundle != null ){
                    var obj=bundle.get("pdus") as Array<Any>
                    var msg = arrayOfNulls<SmsMessage>(obj.size)

                    for (i in obj.indices) {
                        msg[i] = SmsMessage.createFromPdu(obj[i] as ByteArray)
                    }
                    for (i in msg.indices) {
                        str = msg[i]?.originatingAddress + " : " + msg[i]?.messageBody
                        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
