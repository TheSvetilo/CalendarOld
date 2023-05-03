package com.example.calendar.data

import com.example.calendar.data.events.entities.EventDataEntity
import java.util.Date

interface EventDataRepository {

    suspend fun createEvent(event: EventDataEntity)
    suspend fun updateEvent(id: Long, event: EventDataEntity)
    suspend fun deleteEvent(id: Long)
    suspend fun getEvent(id: Long): EventDataEntity
    suspend fun getEventsByDay(date: Date): List<EventDataEntity>?

}