package com.ostapr.a1_7_basic_state

import WellnessTaskItem
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(content = {
        items(list) { task ->
            WellnessTaskItem(task.label, task.checked, onCheckedChange = {
                onCheckedTask(task, it)
            }, onClose = {
                onCloseTask(task)
            })
        }
    }, modifier = modifier)
}