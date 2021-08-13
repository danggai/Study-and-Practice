package com.example.tddexample.util

object StringUtils {
    fun strToInt(str: String): Int {
        return str.filter { it.isDigit() } .toInt()
    }
}