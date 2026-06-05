package com.workshipflow.app.features.songs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workshipflow.app.core.data.repository.SongRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SongsViewModel(
    private val repository: SongRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SongsUiState())
    val uiState: StateFlow<SongsUiState> = _uiState.asStateFlow()

    init {
        loadSongs()
    }

    fun loadSongs() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val suggestions = repository.getSuggestions()
                val inEvaluation = repository.getInEvaluation()
                val repertoire = repository.getSongs()
                
                _uiState.update { 
                    it.copy(
                        suggestions = suggestions,
                        inEvaluation = inEvaluation,
                        repertoire = repertoire,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}
