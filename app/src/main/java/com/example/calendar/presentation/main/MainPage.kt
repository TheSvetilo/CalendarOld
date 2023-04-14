package com.example.calendar.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calendar.R
import com.example.calendar.domain.model.Event

@Composable
fun MainPage(events: List<Event>) {

    var expanded by remember { mutableStateOf<String?>(null) }

    Scaffold(
        backgroundColor = Color(0xFFEDF9FF)
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            modifier = Modifier.padding(padding),
        ) {
            item { Header(title = stringResource(R.string.header_today)) }
            items(events) { event ->
                EventSmallCard(event = event, expanded = expanded == event.title) {
                    expanded = if (expanded == event.title) null else event.title
                }
            }
            item { Spacer(modifier = Modifier.height(16.dp))  }
            item { Header(title = stringResource(R.string.header_soon)) }
            items(events) { event ->
                EventSmallCard(event = event, expanded = expanded == event.title) {
                    expanded = if (expanded == event.title) null else event.title
                }
            }
        }
    }
}

@Composable
fun TodaySection() {
    TODO("Not yet implemented")
}

@Composable
fun SoonSection() {
    TODO("Not yet implemented")
}

@Composable
fun Header(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.h5
    )
}


@Preview(showSystemUi = true)
@Composable
fun MainPagePreview() {
    MainPage(listOf())
}