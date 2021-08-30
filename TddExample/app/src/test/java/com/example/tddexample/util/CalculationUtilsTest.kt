package com.example.tddexample.util

import com.google.common.truth.Truth
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.hamcrest.MatcherAssert
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.shadows.ShadowLog

@RunWith(MockitoJUnitRunner::class)
class CalculationUtilsTest  {

    @Before
    fun setup() {
        ShadowLog.stream = System.out // for logging in jvm
    }

    // same as @Before in JUnit4
    @BeforeEach
    fun setup_() {
        ShadowLog.stream = System.out // for logging in jvm
    }



    @Test
    fun testPlus() {
        // JUnit4
        Assert.assertTrue(CalculationUtils.plus(3,3) == 6)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.plus(3,3), `is`(6))
        // Truth
        Truth.assertThat(CalculationUtils.plus(3,3)).isEqualTo(6)

        // JUnit4
        Assert.assertTrue(CalculationUtils.plus(23,96) == 119)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.plus(23,96), `is`(119))
        // Truth
        Truth.assertThat(CalculationUtils.plus(23,96)).isEqualTo(119)

        // JUnit4
        Assert.assertTrue(CalculationUtils.plus(1000,234) == 1234)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.plus(1000,234), `is`(1234))
        // Truth
        Truth.assertThat(CalculationUtils.plus(1000,234)).isEqualTo(1234)

        // JUnit4
        Assert.assertFalse(CalculationUtils.plus(3,4) == 6)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.plus(3,4), `is`(not(6)))
        // Truth
        Truth.assertThat(CalculationUtils.plus(3,4)).isNotEqualTo(6)
    }

    @Test
    fun testMinus() {
        // JUnit4
        Assert.assertTrue(CalculationUtils.minus(3,3) == 0)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.minus(3,3), `is`(0))
        // Truth
        Truth.assertThat(CalculationUtils.minus(3,3)).isEqualTo(0)

        // JUnit4
        Assert.assertTrue(CalculationUtils.minus(77,33) == 44)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.minus(77,33), `is`(44))
        // Truth
        Truth.assertThat(CalculationUtils.minus(77,33)).isEqualTo(44)

        // JUnit4
        Assert.assertFalse(CalculationUtils.minus(6,4) == 3)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.minus(6,4), `is`(not(3)))
        // Truth
        Truth.assertThat(CalculationUtils.minus(6,4)).isNotEqualTo(3)
    }

    @Test
    fun testMultiple() {
        // JUnit4
        Assert.assertTrue(CalculationUtils.multiple(3,3) == 9)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.multiple(3,3), `is`(9))
        // Truth
        Truth.assertThat(CalculationUtils.multiple(3,3)).isEqualTo(9)

        // JUnit4
        Assert.assertTrue(CalculationUtils.multiple(3,4) == 12)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.multiple(3,4), `is`(12))
        // Truth
        Truth.assertThat(CalculationUtils.multiple(3,4)).isEqualTo(12)

        // JUnit4
        Assert.assertFalse(CalculationUtils.multiple(123124,0) == 6)
        // Hamcrest
        MatcherAssert.assertThat(CalculationUtils.multiple(123124,0), `is`(not(6)))
        // Truth
        Truth.assertThat(CalculationUtils.multiple(123124,0)).isNotEqualTo(6)
    }
}