package com.example.calendar.data.events.entities

import java.util.Date

data class EventDataEntity(
    val id: Long,
    val date: Date,
    val title: String,
    val description: String,
)
