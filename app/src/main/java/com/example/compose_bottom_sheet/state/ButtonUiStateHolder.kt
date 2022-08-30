package com.example.compose_bottom_sheet.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Stable
data class ButtonUiStateHolder(
    val uiState: List<ButtonUiState>
)

@Composable
fun rememberButtonUiStateHolder() : ButtonUiStateHolder {
    // dummy data
    val list = listOf(
        ButtonUiState("A", "B","C"),
        ButtonUiState("D", "E","F"),
        ButtonUiState("G", "H","I"),
        ButtonUiState("J", "K","L"),
        ButtonUiState("M", "N","O"),
        ButtonUiState("P", "Q","R")
    )
    return remember {
        ButtonUiStateHolder(list)
    }
}

