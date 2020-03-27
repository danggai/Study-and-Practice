package com.example.dialogfragmentexample

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment

/**
 * A simple [Fragment] subclass.
 */
class TestDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(activity)
        builder.setTitle("My Title")
        builder.setMessage("My Message.")

        builder.setPositiveButton("positive", DialogListener())
        builder.setNeutralButton("after", DialogListener())
        builder.setNegativeButton("negative", DialogListener())

        return builder.create()
    }

    inner class DialogListener: DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            when(which) {
                DialogInterface.BUTTON_POSITIVE -> Toast.makeText(context, "You pressed Positive.", Toast.LENGTH_SHORT).show()
                DialogInterface.BUTTON_NEUTRAL -> Toast.makeText(context, "You pressed after.", Toast.LENGTH_SHORT).show()
                DialogInterface.BUTTON_NEGATIVE -> Toast.makeText(context, "You pressed Negative.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
