package com.example.tddexample

import android.app.Application
import android.content.Context
import android.os.Looper
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import org.robolectric.Shadows.shadowOf

/**
 * Robolectric를 사용한 Unit Test 구현을 위한 추상 클래스.
 * Koin, MVVM, Mockito, Junit5 환경에서 테스트 됨.
 * @author danggai
 * @since 2021-09-07
 **/

abstract class BaseRobolectricTest: KoinTest {

    val application: Application = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Application
    lateinit var mockContext: Context

    @get:Rule
    val mockProvider = MockProviderRule.create {
            clazz-> Mockito.mock(clazz.java)
    }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()     // to testing livedata

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        androidLogger()

//        androidContext(RuntimeEnvironment.application)                                  // deprecated
        androidContext(ApplicationProvider.getApplicationContext<Application>())        // for using robolectric
//        androidContext(InstrumentationRegistry.getInstrumentation().targetContext)      // for using espresso

//        modules(listOf(myModules))
    }

    @BeforeEach
    @Before
    fun shadowMainLooper() {
        shadowOf(Looper.getMainLooper()).idle()
    }

    @Before
    fun initMockContext() {
        mockContext = application.applicationContext;
    }

}