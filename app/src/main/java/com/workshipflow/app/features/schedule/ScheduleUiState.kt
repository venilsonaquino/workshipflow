package com.workshipflow.app.features.schedule

data class ScheduleUiState(
    val isLoading: Boolean = false,
    val items: List<String> = emptyList(),
    val error: String? = null
)
