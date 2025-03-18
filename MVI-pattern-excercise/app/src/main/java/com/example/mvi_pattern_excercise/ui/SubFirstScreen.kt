package com.example.mvi_pattern_excercise.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.mvi_pattern_excercise.SubFirstViewModel
import com.example.mvi_pattern_excercise.utils.ComposeUtils.getActivity
import org.orbitmvi.orbit.compose.collectAsState


@Composable
fun SubScreen(viewModel: SubFirstViewModel) {
    val state = viewModel.collectAsState()  // 상태 구독
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Welcome to Sub Screen! Well done!",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Button(onClick = {
                Toast.makeText(context, "개발중", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Go to second sub screen")
            }

            Button(onClick = {
                context.getActivity()?.finish()
            }) {
                Text(text = "Go Back")
            }
        }
    }
}