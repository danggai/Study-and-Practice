package com.example.basicdialogexample

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_list_dialog.*
import java.util.*

class MainActivity : AppCompatActivity() {

    class Item(val name: String, val type: String, val alcohol: Double, val imgsrc: String)

    var alcohol = mutableListOf("Blue Curacao", "Bombay Sapphire","Captain Morgan","Disaronno","Gordon's", "Jonnie Walker Black Label", "Jonnie Walker Red Label", "Jose Cuervo", "New Amsterdam", "Smirnoff", "Triple sec")

    var alcohol2 : MutableList<Item> = mutableListOf(
        Item("Blue Curacao", "Liqueur",25.0, "blue_curacao"),
        Item("Bombay Sapphire","Gin", 47.3, "bombay_sapphire"),
        Item("Captain Morgan","Rum", 35.0, "captain_morgan"),
        Item("Disaronno","Liqueur", 31.0, "disaronno"),
        Item("Gordon's", "Gin", 43.0, "gordons"),
        Item("Jonnie Walker Black Label","Vodka", 40.0, "jonnie_black"),
        Item("Jonnie Walker Red Label","Vodka", 40.0, "jonnie_red"),
        Item("Jose Cuervo", "Tequila", 38.0,"jose_cuervo"),
        Item("New Amsterdam","Vodka", 40.0, "new_amsterdam"),
        Item("Smirnoff","Vodka", 40.0, "smirnoff"),
        Item("Triple sec", "Liqueur",40.0, "triplesec")
    )

    var pro: ProgressDialog?= null          // 취소선 = deprecated = 사용 비권장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_normalDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("TITLE")
            builder.setMessage("DESCRIPTION")
            builder.setIcon(R.mipmap.ic_launcher_round)

            val listener = DialogInterface.OnClickListener { dialog, which ->
                when(which) {
                    DialogInterface.BUTTON_POSITIVE -> Toast.makeText(applicationContext, "Positive", Toast.LENGTH_SHORT).show()
                    DialogInterface.BUTTON_NEGATIVE -> Toast.makeText(applicationContext, "Negative", Toast.LENGTH_SHORT).show()
                    DialogInterface.BUTTON_NEUTRAL -> Toast.makeText(applicationContext, "Neutral", Toast.LENGTH_SHORT).show()
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

            val listener = DialogInterface.OnClickListener { dialog, which ->
                val alert = dialog as AlertDialog
                val text1: EditText? = alert.findViewById(R.id.txtEdit1)
                val text2: EditText? = alert.findViewById(R.id.txtEdit2)
                Toast.makeText(applicationContext, "${text1?.text} / ${text2?.text}", Toast.LENGTH_SHORT).show()
            }

            builder.setPositiveButton("SUMMIT", listener)
            builder.setNegativeButton("CANCEL", null)

            builder.show()
        }


        btn_datePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(applicationContext, "${year} / ${month+1} / ${dayOfMonth}", Toast.LENGTH_SHORT).show()   // month는 0부터 시작
            }

            val picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
        }


        btn_timePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR)
            val minute = calendar.get(Calendar.MINUTE)

            val listener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                Toast.makeText(applicationContext, "${hourOfDay} : ${minute}", Toast.LENGTH_SHORT).show()
            }

            val picker = TimePickerDialog(this, listener, hour, minute, false)  // true: 24시간, false: 12시간
            picker.show()
        }


        btn_progressDialog.setOnClickListener {
            pro = ProgressDialog.show(this, "TITLE", "MESSAGE")     // 사용자가 임의로 종료 불가능. 코드로 반드시 종료해야 함.

            val handler = Handler()
            val thread = Runnable { kotlin.run {
                pro?.cancel()
            }}

            handler.postDelayed(thread, 2000)   // 2초 후 thread 실행
        }


        btn_listDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setNegativeButton("CANCEL", null)

            val listener = DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "You selected ${alcohol[which]}.", Toast.LENGTH_SHORT).show()
            }

            builder.setItems(alcohol.toTypedArray(), listener)
            builder.show()
        }


        btn_customListDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("CUSTOM LIST DIALOG")

            var list = ArrayList<HashMap<String, Any>>()
            alcohol2.map {
                var map = HashMap<String, Any>()

                val imgsrc = applicationContext.resources.getIdentifier(it.imgsrc, "drawable", applicationContext.packageName)

                map.put("name", it.name)
                map.put("imgsrc", imgsrc)
                list.add(map)
            }

            var keys = arrayOf("name", "imgsrc")
            var ids = intArrayOf(R.id.txtView, R.id.imgView)

            var adapter = SimpleAdapter(this, list, R.layout.custom_list_dialog, keys, ids)

            var listener = DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(applicationContext, "You selected ${alcohol[which]}.", Toast.LENGTH_SHORT).show()
            }

            builder.setAdapter(adapter, listener)
            builder.setNegativeButton("CANCEL", null)
            builder.show()
        }
    }
}