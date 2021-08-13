package com.example.tddexample.util

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CommonFunctionTest  {

    @Test
    fun testPlus() {
        assertTrue(CommonFunction.plus(3,3) == 6)
        assertTrue(CommonFunction.plus(23,96) == 119)
        assertTrue(CommonFunction.plus(1000,234) == 1234)
        assertFalse(CommonFunction.plus(3,4) == 6)
    }

    @Test
    fun testMinus() {
        assertTrue(CommonFunction.minus(3,3) == 0)
        assertTrue(CommonFunction.minus(77,33) == 44)
        assertFalse(CommonFunction.minus(6,4) == 3)
    }

    @Test
    fun testMultiple() {
        assertTrue(CommonFunction.multiple(3,3) == 9)
        assertTrue(CommonFunction.multiple(3,4) == 12)
        assertFalse(CommonFunction.multiple(123124,0) == 6)
    }
}