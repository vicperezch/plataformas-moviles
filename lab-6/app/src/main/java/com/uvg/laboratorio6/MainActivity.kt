package com.uvg.laboratorio6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.uvg.laboratorio6.layout.CounterLayout
import com.uvg.laboratorio6.ui.theme.Laboratorio6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio6Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}