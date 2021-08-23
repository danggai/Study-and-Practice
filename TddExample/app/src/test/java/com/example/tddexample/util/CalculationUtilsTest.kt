package com.example.tddexample.util

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculationUtilsTest  {

    @Test
    fun testPlus() {
        // JUnit
        assertTrue(CalculationUtils.plus(3,3) == 6)
        // Hamcrest
        assertThat(CalculationUtils.plus(3,3), `is`(6))

        // JUnit
        assertTrue(CalculationUtils.plus(23,96) == 119)
        // Hamcrest
        assertThat(CalculationUtils.plus(23,96), `is`(119))

        // JUnit
        assertTrue(CalculationUtils.plus(1000,234) == 1234)
        // Hamcrest
        assertThat(CalculationUtils.plus(1000,234), `is`(1234))

        // JUnit
        assertFalse(CalculationUtils.plus(3,4) == 6)
        // Hamcrest
        assertThat(CalculationUtils.plus(3,4), `is`(not(6)))
    }

    @Test
    fun testMinus() {
        // JUnit
        assertTrue(CalculationUtils.minus(3,3) == 0)
        // Hamcrest
        assertThat(CalculationUtils.minus(3,3), `is`(0))

        // JUnit
        assertTrue(CalculationUtils.minus(77,33) == 44)
        // Hamcrest
        assertThat(CalculationUtils.minus(77,33), `is`(44))

        // JUnit
        assertFalse(CalculationUtils.minus(6,4) == 3)
        // Hamcrest
        assertThat(CalculationUtils.minus(6,4), `is`(not(3)))
    }

    @Test
    fun testMultiple() {
        // JUnit
        assertTrue(CalculationUtils.multiple(3,3) == 9)
        // Hamcrest
        assertThat(CalculationUtils.multiple(3,3), `is`(9))

        // JUnit
        assertTrue(CalculationUtils.multiple(3,4) == 12)
        // Hamcrest
        assertThat(CalculationUtils.multiple(3,4), `is`(12))

        // JUnit
        assertFalse(CalculationUtils.multiple(123124,0) == 6)
        // Hamcrest
        assertThat(CalculationUtils.multiple(123124,0), `is`(not(6)))
    }
}