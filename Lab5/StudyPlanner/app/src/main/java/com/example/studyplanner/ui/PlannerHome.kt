
package com.example.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class PlannerUiState(
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Study Planner",
            style = MaterialTheme.typography.headlineMedium
        )

        uiState.tasks.forEach { task ->
            Button(
                onClick = { onTaskClick(task) }
            ) {
                Text(task)
            }
        }
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit
) {
    val uiState = PlannerUiState(
        tasks = listOf(
            "Lab 5 Report",
            "Study Kotlin",
            "Review Navigation"
        )
    )

    PlannerHomeScreen(
        uiState = uiState,
        onTaskClick = onTaskClick
    )
}
