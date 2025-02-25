package com.example.mvi_pattern_excercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.mvi_pattern_excercise.ui.SubScreen
import com.example.mvi_pattern_excercise.ui.theme.AppTheme

class SubFirstActivity : ComponentActivity() {
    private val viewModel: SubFirstViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkTheme = true) {
                SubScreen(viewModel)
            }
        }
    }
}