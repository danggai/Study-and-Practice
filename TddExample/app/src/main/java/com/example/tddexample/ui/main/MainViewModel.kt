package com.example.tddexample.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tddexample.util.CommonFunction
import com.example.tddexample.util.NonNullMutableLiveData

class MainViewModel : ViewModel() {
    var firstNumber = NonNullMutableLiveData("")
    var secondNumber = NonNullMutableLiveData("")

    var message = NonNullMutableLiveData("calculate results on here")

    fun onClickPlus() {
        Log.d("myLog", "")
        try {
            setMessage(CommonFunction.plus(firstNumber.value.toInt(), secondNumber.value.toInt()))
        } catch (e: Exception) {
            setMessage("calculate failed.")
            Log.e("error", "")
        }
    }

    fun onClickMinus() {
        Log.d("myLog", "")
        try {
            setMessage( CommonFunction.minus(firstNumber.value.toInt(), secondNumber.value.toInt()))
        } catch (e: Exception) {
            setMessage("calculate failed.")
            Log.e("error", "")
        }
    }

    fun onClickMultiple() {
        Log.d("myLog", "")
        try {
            setMessage( CommonFunction.multiple(firstNumber.value.toInt(), secondNumber.value.toInt()))
        } catch (e: Exception) {
            setMessage("calculate failed.")
            Log.e("error", "")
        }
    }

    private fun setMessage(value: Int) {
        message.value = "Result = $value"
    }

    private fun setMessage(value: String) {
        message.value = value
    }
}