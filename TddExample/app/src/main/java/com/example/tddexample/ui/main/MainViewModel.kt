package com.example.tddexample.ui.main

import androidx.lifecycle.ViewModel
import com.example.tddexample.util.NonNullMutableLiveData

class MainViewModel : ViewModel() {

    var firstNumber = NonNullMutableLiveData("")
    var secondNumber = NonNullMutableLiveData("")

    var message = NonNullMutableLiveData("")

    fun onClickPlus() {
        setMessage( plus(firstNumber.value.toInt(), secondNumber.value.toInt()))
    }

    fun onClickMinus() {
        setMessage( minus(firstNumber.value.toInt(), secondNumber.value.toInt()))
    }

    fun onClickMultiple() {
        setMessage( multiple(firstNumber.value.toInt(), secondNumber.value.toInt()))
    }

    private fun setMessage(value: Int) {
        message.value = "Result = $value"
    }

    private fun plus(origin: Int, dest: Int): Int {
        return origin + dest
    }

    private fun minus(origin: Int, dest: Int): Int {
        return origin - dest
    }

    private fun multiple(origin: Int, dest: Int): Int {
        return origin * dest
    }
}