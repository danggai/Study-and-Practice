package com.example.mvi_pattern_excercise

import android.util.Log
import com.example.mvi_pattern_excercise.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubViewModel @Inject constructor() :
    BaseViewModel<SubContract.Event, SubContract.State, SubContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState(): SubContract.State {
        return SubContract.State()
    }

    override fun handleEvent(event: SubContract.Event) {
        when (event) {
            is SubContract.Event.GenerateNumber -> {
                generateRandomNumber()
            }

            else -> {
                Log.d("SubViewModel", "Not Exist event: $event")
            }
        }
    }

    private fun generateRandomNumber() {
//        setState { copy(randomNumber = Random.nextInt(1, 1001)) }
    }
}
