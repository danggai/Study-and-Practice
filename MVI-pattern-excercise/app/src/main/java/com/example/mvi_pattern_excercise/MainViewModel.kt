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
            is MainContract.Event.GenerateNumber -> {
                generateRandomNumber()
            }

            is MainContract.Event.GuessNumber -> {
                val guessedNumber = event.number

                if (currentState.randomNumber == null) {
                    setEffect { MainContract.Effect.ShowToast("먼저 번호를 생성하세요") }
                    return
                }

                if (currentState.randomNumber.toString() == guessedNumber) {
                    setEffect { MainContract.Effect.ShowToast("정답!") }
                } else {
                    setEffect { MainContract.Effect.ShowToast("땡") }
                }
            }
        }
    }

    private fun generateRandomNumber() {
        setState { copy(randomNumber = Random.nextInt(1, 1001)) }
    }

    fun updatePassword(string: String) {
        setState { copy(password = string) }
    }

    fun clearPassword(string: String) {
        setState { copy(password = "") }
    }
}
