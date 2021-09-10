package com.example.tddexample.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()     // to testing livedata

    private lateinit var vm: MainViewModel

    @BeforeEach
    fun setUp() {
        vm = MainViewModel()
    }

    @Test
    fun setMessage_True_updateLiveData() {
        vm.message.value = "hello"
        Truth.assertThat(vm.message.value).isEqualTo("hello")
    }



}