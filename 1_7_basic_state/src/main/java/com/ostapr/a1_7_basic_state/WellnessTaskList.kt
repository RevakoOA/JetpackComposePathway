package com.ostapr.a1_7_basic_state

import WellnessTaskItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(content = {
        items(list) { task ->
            WellnessTaskItem(task.label, onTaskClose = {
                onCloseTask(task)
            })
        }
    }, modifier = modifier)
}