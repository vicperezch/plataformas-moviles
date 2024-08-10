package com.uvg.laboratorio5.layout

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio5.ui.theme.Laboratorio5Theme
import com.uvg.laboratorio5.R

@Composable
fun MainLayout(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(modifier = modifier) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(MaterialTheme.colorScheme.secondary),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(Color.Gray, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.ic_update),
                        tint = MaterialTheme.colorScheme.onSecondary,
                        contentDescription = null
                    )
                }

                Text(
                    text = "Actualización disponible",
                    textAlign = TextAlign.Left,
                    modifier = Modifier.width(200.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondary
                )

                TextButton(
                    modifier = Modifier,
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp")
                        )

                        context.startActivity(intent)
                    }
                ) {
                    Text(
                        text = "Descargar",
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(modifier = Modifier) {
                    Text(
                        text = "Martes",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "1 de octubre",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                OutlinedButton(
                    modifier = Modifier,
                    shape = RoundedCornerShape(15),
                    onClick = { /*TODO*/}
                ) {
                    Text(
                        text = "Terminar jornada",
                        color = MaterialTheme.colorScheme.secondary,
                    )
                }
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp),
                shape = RoundedCornerShape(1),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Tre Fratelli",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        IconButton(
                            modifier = Modifier.height(30.dp),
                            onClick = {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse("https://maps.app.goo.gl/v7jbtDZLx7NcjZww5")
                                )

                                context.startActivity(intent)
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_directions),
                                contentDescription = null
                            )
                        }
                    }

                    Text(
                        text = "Plaza Fontabella, 4a Avenida Zona 10",
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Text(
                        text = "7:00AM 10:00PM",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(percent = 15),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Victor Manuel Pérez Chávez",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        ) {
                            Text("Iniciar")
                        }

                        TextButton(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(percent = 15),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Comida: Italiana\nCosto: QQQ",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        ) {
                            Text("Detalles")
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMainLayout() {
    Laboratorio5Theme {
        Surface(Modifier.fillMaxSize()) {
            MainLayout(Modifier.fillMaxSize())
        }
    }
}