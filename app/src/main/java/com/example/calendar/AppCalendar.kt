package com.example.calendar

import android.app.Application
import com.example.calendar.data.EventService

class AppCalendar: Application() {

    val events = EventService().getEvents()
}