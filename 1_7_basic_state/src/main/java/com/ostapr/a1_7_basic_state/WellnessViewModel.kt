package com.ostapr.a1_7_basic_state

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask> = _tasks

    fun remove(task: WellnessTask) {
        _tasks.remove(task)
    }

    fun updateTask(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }
    }

    companion object {
        private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
    }
}