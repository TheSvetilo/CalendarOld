package com.example.calendar.domain.event

import com.example.calendar.domain.model.Event
import java.util.Date

interface EventRepository {

    suspend fun createEvent(event: Event)
    suspend fun updateEvent(id: Int, event: Event)
    suspend fun deleteEvent(id: Int)
    suspend fun getEvent(id: Int): Event
    suspend fun getEventsByDay(date: Date): List<Event>?

}