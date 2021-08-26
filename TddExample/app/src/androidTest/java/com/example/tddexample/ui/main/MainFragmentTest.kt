package com.example.tddexample.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.tddexample.MainActivity
import com.example.tddexample.R
import kotlinx.coroutines.delay
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.shadows.ShadowLog

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        ShadowLog.stream = System.out // for logging in jvm
    }

    @MediumTest
    fun initTest() {
        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("calculate results on here")))
    }

    @MediumTest
    fun calculateErrorTest() {
        Espresso.onView(withId(R.id.btn_plus)).perform(click())
        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("calculate failed.")))
    }

    @MediumTest
    fun plusTest() {
        Espresso.onView(withId(R.id.et_origin)).perform(typeText("100"))
        Espresso.onView(withId(R.id.et_another)).perform(typeText("150"))
        Espresso.onView(withId(R.id.btn_plus)).perform(click())
        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("Result = 250")))

        Espresso.onView(withId(R.id.et_origin)).perform(
            clearText(), typeText("1000"))
        Espresso.onView(withId(R.id.et_another)).perform(
            clearText(), typeText("500"))
        Espresso.onView(withId(R.id.btn_plus)).perform(click())
        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("Result = 1500")))
    }

    @MediumTest
    fun minusTest() {
        Espresso.onView(withId(R.id.et_origin)).perform(typeText("300"))
        Espresso.onView(withId(R.id.et_another)).perform(typeText("150"))
        Espresso.onView(withId(R.id.btn_minus)).perform(click())

        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("Result = 150")))
    }

    @MediumTest
    fun multipleTest() {
        Espresso.onView(withId(R.id.et_origin)).perform(typeText("10"))
        Espresso.onView(withId(R.id.et_another)).perform(typeText("25"))
        Espresso.onView(withId(R.id.btn_multiple)).perform(click())

        Espresso.onView(withId(R.id.tv_result)).check(matches(ViewMatchers.withText("Result = 250")))
    }
}