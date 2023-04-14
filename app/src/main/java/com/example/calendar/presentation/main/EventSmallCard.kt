package com.example.calendar.presentation.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calendar.domain.model.Event
import java.util.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EventSmallCard(
    event: Event,
    expanded: Boolean,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, 16.dp, 0.dp)
        ,
        elevation = 2.dp,
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = event.title, fontSize = 20.sp)
            }
            if (expanded) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = event.description)
            }
        }
    }
}

@Preview()
@Composable
fun EventSmallCardPreview() {
    EventSmallCard(
        Event(
            1,
            Date(2023, 3, 8),
            "8 марта",
            "Нужны подарки"
        ),
        expanded = true,
        {}
    )
}