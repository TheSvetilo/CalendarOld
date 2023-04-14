package com.example.calendar.domain.model

import java.util.Date

data class Event(
    val id: Int,
    val date: Date,
    val title: String,
    val description: String,
)
