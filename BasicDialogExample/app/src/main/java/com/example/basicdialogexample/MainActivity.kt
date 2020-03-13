package com.example.basicdialogexample

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_normalDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("TITLE")
            builder.setMessage("DESCRIPTION")
            builder.setIcon(R.mipmap.ic_launcher_round)

            val listener = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which) {
                        DialogInterface.BUTTON_POSITIVE -> Toast.makeText(applicationContext, "Positive", Toast.LENGTH_SHORT).show()
                        DialogInterface.BUTTON_NEGATIVE -> Toast.makeText(applicationContext, "Negative", Toast.LENGTH_SHORT).show()
                        DialogInterface.BUTTON_NEUTRAL -> Toast.makeText(applicationContext, "Neutral", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)

            builder.show()
        }

        btn_customDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("TITLE")
            builder.setIcon(R.mipmap.ic_launcher_round)

            val view = layoutInflater.inflate(R.layout.custom_dialog, null)
            builder.setView(view)

            var listner = object:DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    val alert = dialog as AlertDialog
                    val text1: EditText? = alert.findViewById(R.id.txtEdit1)
                    val text2: EditText? = alert.findViewById(R.id.txtEdit2)
                    Toast.makeText(applicationContext, "${text1?.text} / ${text2?.text}", Toast.LENGTH_SHORT).show()
                }
            }

            builder.setPositiveButton("SUMMIT", listner)
            builder.setNegativeButton("CANCEL", null)

            builder.show()
        }


        btn_datePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listener = object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Toast.makeText(applicationContext, "${year} / ${month+1} / ${dayOfMonth}", Toast.LENGTH_SHORT).show()   // month는 0부터 시작
                }
            }

            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }

        btn_timePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            val listener = object: TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    Toast.makeText(
                        applicationContext,
                        "${hourOfDay} : ${minute}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            var picker = TimePickerDialog(this, listener, hour, minute, false)  // true: 24시간, false: 12시간
            picker.show()
        }
    }
}
