package com.example.seekbarexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listener = SeekListener()
        seekBar1.setOnSeekBarChangeListener(listener)
        seekBar2.setOnSeekBarChangeListener(listener)
        seekBar3.setOnSeekBarChangeListener(listener)
    }

    inner class SeekListener: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            when(seekBar) {
                seekBar1 -> txtView1.text = "Seekbar1 : $progress"
                seekBar2 -> txtView2.text = "Seekbar2 : $progress"
                seekBar3 -> txtView3.text = "Seekbar3 : $progress"
                else -> null
            }
        }
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }
}
