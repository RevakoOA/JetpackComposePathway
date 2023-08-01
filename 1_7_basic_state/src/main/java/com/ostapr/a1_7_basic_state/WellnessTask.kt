package com.ostapr.a1_7_basic_state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue

data class WellnessTask(
    val id: Int,
    val label: String,
    val initialChecked: Boolean = false,
) {
    var checked: Boolean by mutableStateOf(initialChecked)
}