package com.workshipflow.app.features.schedule.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workshipflow.app.core.data.model.Event
import com.workshipflow.app.core.data.network.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EditEventViewModel(
    private val apiService: ApiService // Idealmente via DI
) : ViewModel() {

    private val _uiState = MutableStateFlow(EditEventUiState())
    val uiState: StateFlow<EditEventUiState> = _uiState.asStateFlow()

    fun loadEvent(event: Event) {
        _uiState.update {
            it.copy(
                id = event.id,
                name = event.name,
                time = event.time,
                teamMembers = event.team.map { member -> member.name },
                songs = event.songs.map { song -> song.title }
            )
        }
    }

    fun onNameChange(newName: String) {
        _uiState.update { it.copy(name = newName) }
    }

    fun onTimeChange(newTime: String) {
        _uiState.update { it.copy(time = newTime) }
    }

    fun saveEvent() {
        val currentState = _uiState.value
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                // Aqui converteríamos o UiState de volta para o modelo Event
                // apiService.updateEvent(currentState.id, ...)
                
                // Simulando delay da API
                kotlinx.coroutines.delay(1000)
                
                _uiState.update { it.copy(isLoading = false, isSaved = true) }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
