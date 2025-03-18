package com.example.mvi_pattern_excercise

import com.example.mvi_pattern_excercise.core.UiEffect
import com.example.mvi_pattern_excercise.core.UiEvent
import com.example.mvi_pattern_excercise.core.UiState

class SubFirstContract {
    // Events that user performed
    sealed class Event : UiEvent {
//        object GenerateNumber : Event()
    }

    // Ui View States
    data class State(
        val isLoading: Boolean = false,
    ) : UiState

    // Side effects
    sealed class Effect : UiEffect {
        data class ShowToast(val message: String) : Effect()
    }
}
