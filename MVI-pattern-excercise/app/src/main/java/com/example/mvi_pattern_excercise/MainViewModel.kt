package com.example.mvi_pattern_excercise

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor() :
    ViewModel(), ContainerHost<MainContract.State, MainContract.Effect> {

    override val container = container<MainContract.State, MainContract.Effect>(
        initialState = MainContract.State()
    )

    // Orbit 가이드 상 onEvent를 더 선호
    fun onEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.GenerateNumber -> generateRandomNumber()
            is MainContract.Event.GuessNumber -> guessNumber(event.number)
        }
    }

    private fun generateRandomNumber() = intent {
        reduce { state.copy(randomNumber = Random.nextInt(1, 1001)) }
    }

    private fun guessNumber(guessedNumber: String) = intent {
        if (state.randomNumber == null) {
            postSideEffect(MainContract.Effect.ShowToast("먼저 번호를 생성하세요"))
            return@intent
        }

        if (state.randomNumber.toString() == guessedNumber) {
            postSideEffect(MainContract.Effect.ShowToast("정답!"))
            postSideEffect(MainContract.Effect.StartSubActivity)
        } else {
            postSideEffect(MainContract.Effect.ShowToast("땡"))
        }
    }

    fun updatePassword(string: String) = intent {
        reduce { state.copy(password = string) }
    }

    fun clearPassword() = intent {
        reduce { state.copy(password = "") }
    }
}
