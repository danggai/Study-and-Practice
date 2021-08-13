package com.example.tddexample.util

import android.content.Context
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import com.example.tddexample.MainActivity
import com.example.tddexample.ui.main.MainFragment
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
    @Config(manifest = Config.NONE)
    class StringUtilsTest {

    @Before
    fun setup() {
        ShadowLog.stream = System.out;
    }

    @Test
    fun textView_text_is_right() {
        val activity = ActivityScenario.launch(MainActivity::class.java)
        val fragment = FragmentScenario.launch(MainFragment::class.java)
        onView
        assertEquals("Not set", fragment.)
    }
}