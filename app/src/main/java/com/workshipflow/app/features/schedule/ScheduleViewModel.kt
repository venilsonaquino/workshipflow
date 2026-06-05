package com.workshipflow.app.features.schedule

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ScheduleViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ScheduleUiState())
    val uiState: StateFlow<ScheduleUiState> = _uiState.asStateFlow()

    init {
        loadSchedule()
    }

    private fun loadSchedule() {
        // Dados de exemplo por enquanto
        _uiState.value = ScheduleUiState(
            items = listOf(
                "Culto de Domingo - 10:00",
                "Ensaio do Louvor - Terça 20:00",
                "Reunião de Jovens - Sábado 19:30"
            )
        )
    }
}
