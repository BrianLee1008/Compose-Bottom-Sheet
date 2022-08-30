@file:OptIn(ExperimentalMaterialApi::class)

package com.example.compose_bottom_sheet.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

typealias SheetContent = @Composable ColumnScope.() -> Unit

@Stable
data class AlphabetSortBottomSheetStateHolder(
    val bottomState: ModalBottomSheetState,
    val hideBottomSheet: () -> Unit,
    val sheetItemList: List<AlphabetSortUiState>
) {

}

@Composable
fun rememberAlphabetSortBottomSheetStateHolder(
    bottomState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
): AlphabetSortBottomSheetStateHolder {
    val coroutineScope = rememberCoroutineScope()

    val list = listOf(
        AlphabetSortUiState("A", number = "0101"),
        AlphabetSortUiState("A", number = "0202"),
        AlphabetSortUiState("A", number = "0303"),
        AlphabetSortUiState("A", number = "0404"),
        AlphabetSortUiState("B", number = "0101"),
        AlphabetSortUiState("B", number = "0202"),
        AlphabetSortUiState("B", number = "0303"),
        AlphabetSortUiState("B", number = "0404"),
        AlphabetSortUiState("C", number = "0101"),
        AlphabetSortUiState("C", number = "0202"),
        AlphabetSortUiState("C", number = "0303"),
        AlphabetSortUiState("C", number = "0404"),
        AlphabetSortUiState("D", number = "0101"),
        AlphabetSortUiState("D", number = "0202"),
        AlphabetSortUiState("D", number = "0303"),
        AlphabetSortUiState("D", number = "0404"),
        AlphabetSortUiState("E", number = "0101"),
        AlphabetSortUiState("E", number = "0202"),
        AlphabetSortUiState("E", number = "0303"),
        AlphabetSortUiState("E", number = "0404"),
        AlphabetSortUiState("F", number = "0101"),
        AlphabetSortUiState("F", number = "0202"),
        AlphabetSortUiState("F", number = "0303"),
        AlphabetSortUiState("F", number = "0404"),
        AlphabetSortUiState("G", number = "0101"),
        AlphabetSortUiState("G", number = "0202"),
        AlphabetSortUiState("G", number = "0303"),
        AlphabetSortUiState("G", number = "0404"),
        AlphabetSortUiState("H", number = "0101"),
        AlphabetSortUiState("H", number = "0202"),
        AlphabetSortUiState("H", number = "0303"),
        AlphabetSortUiState("H", number = "0404"),
        AlphabetSortUiState("I", number = "0101"),
        AlphabetSortUiState("I", number = "0202"),
        AlphabetSortUiState("I", number = "0303"),
        AlphabetSortUiState("I", number = "0404"),
        AlphabetSortUiState("J", number = "0101"),
        AlphabetSortUiState("J", number = "0202"),
        AlphabetSortUiState("J", number = "0303"),
        AlphabetSortUiState("J", number = "0404"),
        AlphabetSortUiState("K", number = "0101"),
        AlphabetSortUiState("K", number = "0202"),
        AlphabetSortUiState("K", number = "0303"),
        AlphabetSortUiState("K", number = "0404"),
        AlphabetSortUiState("L", number = "0101"),
        AlphabetSortUiState("L", number = "0202"),
        AlphabetSortUiState("L", number = "0303"),
        AlphabetSortUiState("L", number = "0404"),
        AlphabetSortUiState("M", number = "0101"),
        AlphabetSortUiState("M", number = "0202"),
        AlphabetSortUiState("M", number = "0303"),
        AlphabetSortUiState("M", number = "0404"),
        AlphabetSortUiState("N", number = "0101"),
        AlphabetSortUiState("N", number = "0202"),
        AlphabetSortUiState("N", number = "0303"),
        AlphabetSortUiState("N", number = "0404"),
        AlphabetSortUiState("O", number = "0101"),
        AlphabetSortUiState("O", number = "0202"),
        AlphabetSortUiState("O", number = "0303"),
        AlphabetSortUiState("O", number = "0404"),
        AlphabetSortUiState("P", number = "0101"),
        AlphabetSortUiState("P", number = "0202"),
        AlphabetSortUiState("P", number = "0303"),
        AlphabetSortUiState("P", number = "0404"),
        AlphabetSortUiState("Q", number = "0101"),
        AlphabetSortUiState("Q", number = "0202"),
        AlphabetSortUiState("Q", number = "0303"),
        AlphabetSortUiState("Q", number = "0404"),
        AlphabetSortUiState("R", number = "0101"),
        AlphabetSortUiState("R", number = "0202"),
        AlphabetSortUiState("R", number = "0303"),
        AlphabetSortUiState("R", number = "0404"),


        )

    val hideSheet: () -> Unit = {
        coroutineScope.launch { hideBottomSheet(bottomState = bottomState) }
    }

    return remember(
        bottomState
    ) {
        AlphabetSortBottomSheetStateHolder(
            bottomState = bottomState,
            sheetItemList = list,
            hideBottomSheet = hideSheet
        )
    }
}

fun showBottomSheet(
    bottomState: ModalBottomSheetState,
    sheetContent: SheetContent,
    coroutineScope: CoroutineScope
) {
    content = sheetContent
    coroutineScope.launch {
        bottomState.show()
    }
}

suspend fun hideBottomSheet(bottomState: ModalBottomSheetState) {
    bottomState.hide()
}

var content: SheetContent by mutableStateOf({
    Column(Modifier.defaultMinSize(minHeight = 1.dp)) {
        /* sheet content */
    }
})

