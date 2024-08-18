package com.uvg.laboratorio6.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.laboratorio6.ui.theme.Laboratorio6Theme
import com.uvg.laboratorio6.R
import com.uvg.laboratorio6.ui.theme.IncrementGreen

@Composable
fun CounterLayout(modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    var increments by rememberSaveable { mutableIntStateOf(0) }
    var decrements by rememberSaveable { mutableIntStateOf(0) }
    var maxValue by rememberSaveable { mutableIntStateOf(0) }
    var minValue by rememberSaveable { mutableIntStateOf(0) }
    val history = remember { mutableStateListOf<Int>() }

    Column(modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Header(
            modifier = Modifier.fillMaxWidth(),
            counter = counter,
            onPlusClick = {
                counter++
                increments++
                history.add(1)
                if (counter > maxValue) maxValue = counter
            },
            onMinusClick = {
                counter--
                decrements++
                history.add(-1)
                if (counter < minValue) minValue = counter
            }
        )

        Statistics(
            modifier = Modifier.padding(16.dp),
            increments = increments.toString(),
            decrements = decrements.toString(),
            totalChanges = (increments + decrements).toString(),
            max = maxValue.toString(),
            min = minValue.toString()
        )

        HistoryGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            historyList = history,
            onRestart = {
                counter = 0
                increments = 0
                decrements = 0
                maxValue = 0
                minValue = 0
                history.clear()
            }
        )
    }
}

@Composable
private fun Header(
    modifier: Modifier = Modifier,
    counter: Int,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Victor Pérez",
            style = MaterialTheme.typography.displayMedium
        )

        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilledIconButton(onClick = onMinusClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = null
                )
            }

            Text(
                text = counter.toString(),
                style = MaterialTheme.typography.displayLarge
            )

            FilledIconButton(onClick = onPlusClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }

        HorizontalDivider()
    }
}

@Composable
private fun Statistics(
    modifier: Modifier = Modifier,
    increments: String,
    decrements: String,
    totalChanges: String,
    max: String,
    min: String
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StatisticRow(
            label = "Total incrementos:",
            value = increments
        )

        StatisticRow(
            label = "Total decrementos:",
            value = decrements
        )

        StatisticRow(
            label = "Valor máximo:",
            value = max
        )

        StatisticRow(
            label = "Valor mínimo:",
            value = min
        )

        StatisticRow(
            label = "Total cambios:",
            value = totalChanges
        )

        StatisticRow(
            label = "Historial:",
            value = ""
        )
    }
}

@Composable
private fun StatisticRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Composable
private fun HistoryGrid(
    modifier: Modifier = Modifier,
    historyList: List<Int>,
    onRestart: () -> Unit
) {
    var count = 0

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            modifier = Modifier.weight(1f),
            columns = GridCells.FixedSize(60.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(historyList) { history ->
                count += history

                if (history == 1) {
                    HistoryBox(
                        modifier = Modifier
                            .background(
                                color = IncrementGreen,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .width(20.dp)
                            .height(50.dp),
                        item = count.toString()
                    )

                } else {
                    HistoryBox(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.error,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .width(20.dp)
                            .height(50.dp),
                        item = count.toString()
                    )
                }
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = onRestart
        ) {
            Text(
                text = "Reiniciar"
            )
        }
    }
}

@Composable
private fun HistoryBox(
    modifier: Modifier = Modifier,
    item: String
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun PreviewCounterLayout() {
    Laboratorio6Theme {
        Surface {
            CounterLayout(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}