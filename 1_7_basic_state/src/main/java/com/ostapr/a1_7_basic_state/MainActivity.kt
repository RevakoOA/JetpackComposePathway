package com.ostapr.a1_7_basic_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
private fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(Modifier.fillMaxSize()) {
            StatefullWaterCounter()

            WellnessTasksList(
                wellnessViewModel.tasks,
                onCheckedTask = { task, checked -> wellnessViewModel.updateTask(task, checked) },
                onCloseTask = { task -> wellnessViewModel.remove(task) },
                modifier = modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun StatefullWaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessWaterCounter(count, onIncrease = {
        count += 1
    }, modifier = modifier)
}

@Composable
private fun StatelessWaterCounter(
    count: Int,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (count > 0) {
            Text(
                text = "You've had $count glasses.",
                modifier = Modifier.padding(16.dp)
            )
        }
        Button(
            onClick = onIncrease,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterCounterPreview() {
    BasicStateTheme {
        StatefullWaterCounter()
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessScreenPreview() {
    BasicStateTheme {
        WellnessScreen()
    }
}