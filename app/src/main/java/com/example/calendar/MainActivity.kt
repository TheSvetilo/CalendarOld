package com.example.calendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import com.example.calendar.presentation.main.MainPage
import com.example.calendar.presentation.ui.theme.CalendarTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val events = AppCalendar().events

        setContent {
            CalendarTheme {
                // A surface container using the 'background' color from the theme
                MainPage(events)
            }
        }
    }
}
