package com.example.mvi_pattern_excercise

import android.widget.Toast
import com.example.mvi_pattern_excercise.core.BaseActivity
import com.example.mvi_pattern_excercise.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutResId(): Int = R.layout.activity_main
    override fun getViewModelClass() = MainViewModel::class.java

    override fun initialize() {
        binding.btn.setOnClickListener {
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
            viewModel.setEvent(MainContract.Event.OnButtonClicked)
        }
    }
}