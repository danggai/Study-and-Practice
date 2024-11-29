package com.example.mvi_pattern_excercise

import com.example.mvi_pattern_excercise.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor() :
    BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    /**
     * Create initial State of Views
     */
    override fun createInitialState(): MainContract.State {
        return MainContract.State()
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            MainContract.Event.OnButtonClicked -> {
                generateRandomNumber()
            }
        }
    }

    private fun generateRandomNumber() {
        setState { copy(randomNumber = Random.nextInt(1, 1001)) }
    }
}
