package com.uvg.laboratorio7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.laboratorio7.layout.NotificationLayout
import com.uvg.laboratorio7.ui.theme.Laboratorio7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val notifications = rememberSaveable {
                        generateFakeNotifications()
                    }

                    NotificationLayout(
                        modifier = Modifier.padding(innerPadding),
                        notifications = notifications
                    )
                }
            }
        }
    }
}
