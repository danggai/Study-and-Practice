package com.example.mvi_pattern_excercise.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mvi_pattern_excercise.MainContract
import com.example.mvi_pattern_excercise.MainViewModel


@Composable
fun MainScreen(viewModel: MainViewModel) {
    var showToast by remember { mutableStateOf(false) }

    if (showToast) {
        Toast.makeText(LocalContext.current, "Button Clicked!", Toast.LENGTH_SHORT).show()
        showToast = false
    }

    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Hello World!", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                showToast = true
                viewModel.setEvent(MainContract.Event.OnButtonClicked)
            }) {
                Text(text = "hello im button")
            }
        }
    }
}