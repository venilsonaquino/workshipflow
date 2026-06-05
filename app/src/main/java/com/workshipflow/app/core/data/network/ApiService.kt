package com.workshipflow.app.core.data.network

import com.workshipflow.app.core.data.model.Schedule
import com.workshipflow.app.core.data.model.Song
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("schedules")
    suspend fun getSchedules(): List<Schedule>

    @GET("schedules/{id}")
    suspend fun getScheduleById(@Path("id") id: String): Schedule

    @GET("songs")
    suspend fun getSongs(): List<Song>

    @GET("songs/suggestions")
    suspend fun getSongSuggestions(): List<Song>
}
