package com.example.calendar.data

import com.example.calendar.domain.event.EventRepository
import com.example.calendar.domain.model.Event
import java.util.*


class EventService: EventRepository {

    private val events = mutableListOf<Event>()
    private fun fillEvents() {
        events.add(
            Event(1, Date(2023, 3, 8), "8 Марта", "Нужны цветочки и билеты в театр."),
        )
        events.add(
            Event(2, Date(2023, 3, 11), "День Рождения Влада", "Придумать подарок и забронировать столик в SmokeBBQ."),
        )
        events.add(
            Event(2, Date(2023, 4, 12), "День Рождения Анечки", "Нужен подарок."),
        )
    }

    override suspend fun createEvent(event: Event) {
        events.add(event)
    }

    override suspend fun updateEvent(id: Int, event: Event) {
        events[id] = event
    }

    override suspend fun deleteEvent(id: Int) {
        events.removeAt(id)
    }

    override suspend fun getEvent(id: Int): Event {
        return events[id]
    }

    override suspend fun getEventsByDay(date: Date): List<Event>? {
        return events.filter {
            it.date == date
        }
    }

    fun getEvents(): List<Event> {
        fillEvents()
        return events
    }
}