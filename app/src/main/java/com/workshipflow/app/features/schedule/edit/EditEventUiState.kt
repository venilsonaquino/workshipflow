package com.workshipflow.app.features.schedule.edit

data class EditEventUiState(
    val id: String = "",
    val name: String = "",
    val time: String = "",
    val teamMembers: List<String> = emptyList(),
    val songs: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val isSaved: Boolean = false,
    val error: String? = null
)
