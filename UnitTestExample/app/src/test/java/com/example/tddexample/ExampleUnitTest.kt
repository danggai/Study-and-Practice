package com.example.tddexample

import org.junit.Test

import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

/**
 * Example local unit test, which will execute on the development machine (host).
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    private fun randomList(size: Int): MutableList<Int> {
        val result = mutableListOf<Int>()

        for (i in 0..size) {
            result.add(Random.Default.nextInt(size))
        }

        return result
    }

    @ExperimentalTime
    @Test
    fun test() {
        var listSize: Int = 10000
        val tolerance: Int = 10000

        for (i in 1..10) {
            val list = randomList(listSize)
            val target = list[Random.nextInt(listSize)]

            list.sort()

            val elapsed1 = measureTimedValue {
                for (item in list) {
                    if (item == target) break
                }
            }
            println("search item use FOR condition -> ${elapsed1.duration}")

            val targetCondition = { item: Int -> item == target }
            val elapsed2 = measureTimedValue {
                list.find(targetCondition)
            }
            println("search item use FIND condition -> ${elapsed2.duration}\n")

            listSize += tolerance
        }
    }
}