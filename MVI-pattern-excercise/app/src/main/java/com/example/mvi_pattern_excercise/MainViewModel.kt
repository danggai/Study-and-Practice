package com.example.mvi_pattern_excercise

import com.example.mvi_pattern_excercise.core.BaseViewModel


class MainViewModel: BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {
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

    private fun generateRandomNumber()  {
        // TODO: do something
    }
}
