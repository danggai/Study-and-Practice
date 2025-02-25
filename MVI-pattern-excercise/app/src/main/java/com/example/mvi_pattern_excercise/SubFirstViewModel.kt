package com.example.mvi_pattern_excercise

import android.util.Log
import com.example.mvi_pattern_excercise.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubFirstViewModel @Inject constructor() :
    BaseViewModel<SubFirstContract.Event, SubFirstContract.State, SubFirstContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState(): SubFirstContract.State {
        return SubFirstContract.State()
    }

    override fun handleEvent(event: SubFirstContract.Event) {
        when (event) {
            else -> {
                Log.d("SubViewModel", "Not Exist event: $event")
            }
        }
    }
}
