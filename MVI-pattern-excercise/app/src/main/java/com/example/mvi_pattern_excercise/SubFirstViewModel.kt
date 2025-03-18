package com.example.mvi_pattern_excercise

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SubFirstViewModel @Inject constructor() :
    ViewModel(), ContainerHost<SubFirstContract.State, SubFirstContract.Effect> {

    override val container = container<SubFirstContract.State, SubFirstContract.Effect>(
        initialState = SubFirstContract.State()
    )

    fun onEvent(event: SubFirstContract.Event) {
        when (event) {
            else -> Log.d("SubViewModel", "Not Exist event: $event")
        }
    }
}
