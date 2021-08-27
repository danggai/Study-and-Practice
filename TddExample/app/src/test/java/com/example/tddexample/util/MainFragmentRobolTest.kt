package com.example.tddexample.util

import android.util.Log
import androidx.fragment.app.testing.FragmentScenario
import androidx.lifecycle.MutableLiveData
import com.example.tddexample.R
import com.example.tddexample.ui.main.MainFragment
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
    @Config(manifest = Config.NONE)
    class MainFragmentRobolTest {

    private lateinit var fragment: FragmentScenario<MainFragment>

    @Before
    fun setup() {
        ShadowLog.stream = System.out // for logging in jvm
        fragment = FragmentScenario.launch(MainFragment::class.java)
    }

    @Test
    fun initFragmentTest() {
        fragment.onFragment { frag ->
            MatcherAssert.assertThat(frag.binding.tvResult.text.toString(), `is`("calculate results on here"))
        }
    }

    @Test
    fun plusTest() {
        fragment.onFragment { frag ->
            frag.binding.etOrigin.setText("100")
            frag.binding.etAnother.setText("150")
            frag.binding.btnPlus.performClick()

            Log.e("", frag.binding.tvResult.text.toString())

//            MatcherAssert.assertThat(frag.binding.tvResult.text.toString(), `is`("Result = 250"))
            TODO("onClick시 이벤트 발생하나 tvResult 값 변경 되지 않음")
        }
    }
}