package com.uvg.laboratorio7.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme

@Composable
fun NotificationLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        TopLayout()
        NotificationContainer(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .fillMaxSize()
        )
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun TopLayout() {
    TopAppBar(
        title = {
            Text(text = "Notificaciones")
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Composable
private fun NotificationContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Tipos de notificaciones"
        )

        Row(modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = "General")
                }
            )

            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = "Publicaciones")
                }
            )

            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = "Mensajes")
                }
            )

            FilterChip(
                selected = false,
                onClick = { /*TODO*/ },
                label = { 
                    Text(text = "Likes")
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 2.dp, color = MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(16.dp))
        ) {

        }
    }
}

@Preview
@Composable
private fun PreviewNotificationLayout() {
    Laboratorio7Theme {
        Surface {
            NotificationLayout(modifier = Modifier.fillMaxSize())
        }
    }
}
