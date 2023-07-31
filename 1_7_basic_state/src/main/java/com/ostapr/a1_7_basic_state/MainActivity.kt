package com.ostapr.a1_7_basic_state

import WellnessTaskItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ostapr.a1_7_basic_state.ui.theme.BasicStateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicStateTheme {
                WellnessScreen()
            }
        }
    }
}

@Composable
private fun WellnessScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        WaterCounter()
    }
}

@Composable
private fun WaterCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 mins walk today?",
                    onClose = { showTask = false })
            }
            Text(
                text = "You've had $count glasses.",
                modifier = Modifier.padding(16.dp)
            )
        }
        Row() {
            Button(
                onClick = { count += 1 },
                enabled = count < 10,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Add one")
            }
            Spacer(Modifier.size(10.dp))
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("Clear water count")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterCounterPreview() {
    BasicStateTheme {
        WaterCounter()
    }
}