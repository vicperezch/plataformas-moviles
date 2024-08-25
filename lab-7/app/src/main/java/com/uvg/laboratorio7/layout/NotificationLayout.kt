package com.uvg.laboratorio7.layout

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio7.Notification
import com.uvg.laboratorio7.NotificationType
import com.uvg.laboratorio7.generateFakeNotifications
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme
import java.util.Locale

@Composable
fun NotificationLayout(
    modifier: Modifier = Modifier,
    notifications: List<Notification>
) {
    var selectedType by rememberSaveable {
        mutableStateOf<NotificationType?>(null)
    }


    Column(modifier = modifier) {
        TopLayout()

        NotificationContainer(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .fillMaxSize(),
            notifications = notifications,
            selectedType = selectedType,
            onGeneralClick = {
                if (selectedType != NotificationType.GENERAL) {
                    selectedType = NotificationType.GENERAL

                } else {
                    selectedType = null
                }
            },
            onLikesClick = {
                if (selectedType != NotificationType.NEW_LIKE) {
                    selectedType = NotificationType.NEW_LIKE

                } else {
                    selectedType = null
                }
            },
            onPostsClick = {
                if (selectedType != NotificationType.NEW_POST) {
                    selectedType = NotificationType.NEW_POST

                } else {
                    selectedType = null
                }
            },
            onMessagesClick = {
                if (selectedType != NotificationType.NEW_MESSAGE) {
                    selectedType = NotificationType.NEW_MESSAGE

                } else {
                    selectedType = null
                }
            }
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
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
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
private fun NotificationContainer(
    modifier: Modifier = Modifier,
    notifications: List<Notification>,
    selectedType: NotificationType?,
    onGeneralClick: () -> Unit,
    onPostsClick: () -> Unit,
    onMessagesClick: () -> Unit,
    onLikesClick: () -> Unit,
) {
    val sdf = SimpleDateFormat("dd MMM • HH:mm", Locale.getDefault())

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = "Tipos de notificaciones",
            fontWeight = FontWeight.Bold
        )

        Row(modifier = Modifier
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            FilterChip(
                selected = (NotificationType.GENERAL == selectedType),
                onClick = onGeneralClick,
                label = {
                    Text(text = "General")
                }
            )

            FilterChip(
                selected = (NotificationType.NEW_POST == selectedType),
                onClick = onPostsClick,
                label = {
                    Text(text = "Publicaciones")
                }
            )

            FilterChip(
                selected = (NotificationType.NEW_MESSAGE == selectedType),
                onClick = onMessagesClick,
                label = {
                    Text(text = "Mensajes")
                }
            )

            FilterChip(
                selected = (NotificationType.NEW_LIKE == selectedType),
                onClick = onLikesClick,
                label = { 
                    Text(text = "Likes")
                }
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val filteredNotifications = if (selectedType != null) {
                notifications.filter { it.type == selectedType }
            } else {
                notifications
            }

            items(filteredNotifications) {not ->
                NotificationItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    notification = not,
                    dateFormat = sdf
                )
            }
        }
    }
}

@Composable
private fun NotificationItem(
    modifier: Modifier = Modifier,
    notification: Notification,
    dateFormat: SimpleDateFormat
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (notification.type) {
            NotificationType.GENERAL -> {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.primaryContainer)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            NotificationType.NEW_LIKE -> {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            NotificationType.NEW_POST -> {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null,
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.tertiaryContainer)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }

            else -> {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null,
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colorScheme.errorContainer)
                        .padding(8.dp),
                    tint = MaterialTheme.colorScheme.onErrorContainer
                )
            }
        }

        Column(
            modifier = Modifier
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = notification.title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(2f)
                )

                Text(
                    text = dateFormat.format(notification.sendAt),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Text(
                text = notification.body,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
private fun PreviewNotificationLayout() {
    val nots = rememberSaveable{ generateFakeNotifications() }

    Laboratorio7Theme {
        Surface {
            NotificationLayout(modifier = Modifier.fillMaxSize(), nots)
        }
    }
}
