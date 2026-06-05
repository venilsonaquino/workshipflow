package com.workshipflow.app.features.songs

import com.workshipflow.app.core.data.model.Song

data class SongsUiState(
    val suggestions: List<Song> = emptyList(),
    val inEvaluation: List<Song> = emptyList(),
    val repertoire: List<Song> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
