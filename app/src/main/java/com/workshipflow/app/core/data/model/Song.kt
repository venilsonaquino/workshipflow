package com.workshipflow.app.core.data.model

enum class SongStatus {
    NOVO,
    URGENTE,
    REPERTÓRIO,
    EM_APRENDIZADO
}

data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val status: SongStatus,
    val bpm: Int? = null,
    val key: String? = null,
    val progress: Float = 0f
)
