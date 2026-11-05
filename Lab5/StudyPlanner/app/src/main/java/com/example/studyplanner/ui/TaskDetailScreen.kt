
package com.example.studyplanner.ui

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class TaskDetailUiState(
    val title: String = ""
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = uiState.title,
            style = MaterialTheme.typography.headlineMedium
        )

        Button(onClick = onShareClick) {
            Text("Share")
        }

        OutlinedButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}

@Composable
fun TaskDetailRoute(
    title: String,
    onBackClick: () -> Unit
) {
    val context = LocalContext.current

    TaskDetailScreen(
        uiState = TaskDetailUiState(title = title),
        onShareClick = {
            val send = Intent(Intent.ACTION_SEND).apply {
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Today I'm studying: $title"
                )
                type = "text/plain"
            }

            context.startActivity(
                Intent.createChooser(send, "Share via")
            )
        },
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true)
@Composable
fun TaskDetailPreview1() {
    MaterialTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState("Lab 5 Report"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskDetailPreview2() {
    MaterialTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState("Study Kotlin"),
            onShareClick = {},
            onBackClick = {}
        )
    }
}
