package com.uvg.frontendbasico.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.frontendbasico.ui.theme.FrontendBasicoTheme

@Composable
fun MainLayout(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = "Universidad del Valle de Guatemala")
        Text(text = "Programación de plataformas móviles, Sección 30")

        Row(modifier) {
            Text(text = "Intregrantes")

            Column(modifier) {
                Text(text = "Victor Pérez")
                Text(text = "Juan Solís")
            }
        }

        Row(modifier) {
            Text(text = "Catedrático")
            Text(text = "Juan Carlos Durini")
        }

        Text(text = "Victor Pérez")
        Text(text = "23731")
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMainLayout() {
    FrontendBasicoTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            MainLayout()
        }
    }
}