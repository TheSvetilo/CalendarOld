package com.example.calendar.data


import android.content.res.Resources.NotFoundException
import com.example.calendar.data.events.entities.EventDataEntity
import java.util.*


class EventService : EventDataRepository {

    private val events = mutableListOf<EventDataEntity>()
    private fun fillEvents() {
        events.add(
            EventDataEntity(1L, Date(2023, 3, 8), "8 Марта", "Нужны цветочки и билеты в театр."),
        )
        events.add(
            EventDataEntity(
                2L,
                Date(2023, 3, 11),
                "День Рождения Влада",
                "Придумать подарок и забронировать столик в SmokeBBQ."
            ),
        )
        events.add(
            EventDataEntity(2L, Date(2023, 4, 12), "День Рождения Анечки", "Нужен подарок."),
        )
    }

    override suspend fun createEvent(event: EventDataEntity) {
        events.add(event)
    }

    override suspend fun updateEvent(id: Long, event: EventDataEntity) {
        val index = events.indexOfFirst { it.id == id }
        if (index == -1) throw NotFoundException()
        events[index] = event
    }

    override suspend fun deleteEvent(id: Long) {
        val index = events.indexOfFirst { it.id == id }
        if (index == -1) throw NotFoundException()
        events.removeAt(index)
    }

    override suspend fun getEvent(id: Long): EventDataEntity {
        return events.firstOrNull { it.id == id } ?: throw NotFoundException()
    }

    override suspend fun getEventsByDay(date: Date): List<EventDataEntity> {
        return events.filter { it.date == date }
    }

    fun getEvents(): List<EventDataEntity> {
        fillEvents()
        return events
    }
}