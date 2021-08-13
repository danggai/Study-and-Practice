package com.example.tddexample.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculationUtilsTest  {

    @Test
    fun testPlus() {
        assertTrue(CalculationUtils.plus(3,3) == 6)
        assertTrue(CalculationUtils.plus(23,96) == 119)
        assertTrue(CalculationUtils.plus(1000,234) == 1234)
        assertFalse(CalculationUtils.plus(3,4) == 6)
    }

    @Test
    fun testMinus() {
        assertTrue(CalculationUtils.minus(3,3) == 0)
        assertTrue(CalculationUtils.minus(77,33) == 44)
        assertFalse(CalculationUtils.minus(6,4) == 3)
    }

    @Test
    fun testMultiple() {
        assertTrue(CalculationUtils.multiple(3,3) == 9)
        assertTrue(CalculationUtils.multiple(3,4) == 12)
        assertFalse(CalculationUtils.multiple(123124,0) == 6)
    }
}