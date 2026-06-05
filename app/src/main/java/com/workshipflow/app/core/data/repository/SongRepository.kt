package com.workshipflow.app.core.data.repository

import com.workshipflow.app.core.data.model.Song
import com.workshipflow.app.core.data.network.ApiService
import com.workshipflow.app.core.data.network.RetrofitClient

class SongRepository(
    private val apiService: ApiService
) {
    suspend fun getSongs(): List<Song> = apiService.getSongs()
    
    suspend fun getSuggestions(): List<Song> = apiService.getSongSuggestions()
    
    // Simulação para o estado "Em Avaliação"
    suspend fun getInEvaluation(): List<Song> = apiService.getSongs().filter { it.status.name == "EM_APRENDIZADO" }
}
