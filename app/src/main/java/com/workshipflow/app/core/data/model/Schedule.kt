package com.workshipflow.app.core.data.model

data class Schedule(
    val id: String,
    val title: String,
    val date: String,
    val events: List<Event>
)

data class Event(
    val id: String,
    val name: String,
    val time: String,
    val team: List<TeamMember>,
    val songs: List<Song> = emptyList()
)

data class TeamMember(
    val id: String,
    val name: String,
    val role: String
)
