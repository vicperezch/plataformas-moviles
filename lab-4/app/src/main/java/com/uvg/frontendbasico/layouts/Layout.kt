package com.uvg.frontendbasico.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.frontendbasico.ui.theme.FrontendBasicoTheme
import com.uvg.frontendbasico.R
import com.uvg.frontendbasico.ui.theme.GreenUVG

@Composable
fun MainLayout(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .border(5.dp, GreenUVG)
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_uvg),
            contentDescription = "Logo UVG",
            alpha = 0.2f
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Universidad del Valle de Guatemala",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            
            Text(
                text = "Programación de plataformas móviles, Sección 30",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "INTEGRANTES",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.5f)
                )

                Column(
                    modifier = Modifier.weight(0.5f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Victor Pérez")
                    Text(text = "Juan Solís")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "CATEDRÁTICO",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(0.5f)
                )

                Text(
                    text = "Juan Carlos Durini",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(0.5f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Victor Pérez")
            Text(text = "23731")
        }
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