package com.example.mvi_pattern_excercise.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mvi_pattern_excercise.MainContract
import com.example.mvi_pattern_excercise.MainViewModel
import com.example.mvi_pattern_excercise.SubFirstActivity
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state = viewModel.collectAsState()  // 상태 구독
    val context = LocalContext.current

    viewModel.collectSideEffect { effect ->
        when (effect) {
            is MainContract.Effect.ShowToast -> {
                Toast.makeText(context, effect.message, Toast.LENGTH_SHORT).show()
            }

            is MainContract.Effect.StartSubActivity -> {
                context.startActivity(Intent(context, SubFirstActivity::class.java))
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Hello World!",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "random Number = ${state.value.randomNumber ?: "not exist"}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                Toast.makeText(context, "Number Changed!", Toast.LENGTH_SHORT).show()
                viewModel.onEvent(MainContract.Event.GenerateNumber)
            }) {
                Text(text = "generate number")
            }

            Spacer(modifier = Modifier.height(16.dp))

            val password = remember { mutableStateOf(state.value.password) }
            TextField(
                value = password.value,
                onValueChange = { newValue ->
                    password.value = newValue
                    viewModel.updatePassword(newValue)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                viewModel.onEvent(MainContract.Event.GuessNumber(state.value.password))
            }) {
                Text(text = "submit")
            }
        }
    }
}

// 내일은 이거 오르빗으로 해보기