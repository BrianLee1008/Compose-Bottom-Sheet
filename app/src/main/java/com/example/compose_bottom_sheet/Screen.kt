@file:Suppress("OPT_IN_USAGE_FUTURE_ERROR")

package com.example.compose_bottom_sheet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_bottom_sheet.component.AlphabetSortBottomSheet
import com.example.compose_bottom_sheet.component.ButtonGroup
import com.example.compose_bottom_sheet.state.*

@Composable
fun Screen(
    buttonUiStateHolder: ButtonUiStateHolder,
    alphabetSortBottomSheetStateHolder: AlphabetSortBottomSheetStateHolder
) {
    val coroutineScope = rememberCoroutineScope()

    val clickListener: (buttonTitle: String) -> Unit = {
        val list = alphabetSortBottomSheetStateHolder.sheetItemList.filter { item ->
            item.name == it
        }
        showBottomSheet(
            bottomState = alphabetSortBottomSheetStateHolder.bottomState,
            coroutineScope = coroutineScope,
            sheetContent = {
                AlphabetSortBottomSheet(
                    sheetTitle = it,
                    list = list,
                    selectedItem = { name, number ->
                        Log.d("TestTest", "$name _____ $number")
                    },
                    // ERNote 안 닫힘.. 왜?
                    hideBottomSheet = alphabetSortBottomSheetStateHolder.hideBottomSheet
                )
            }
        )

    }
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colors.onSurface)
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 46.dp, bottom = 10.dp)
    ) {
        buttonUiStateHolder.uiState.forEach {
            Column {
                ButtonGroup(
                    firstButtonTitle = it.firstButtonTitle,
                    secondButtonTitle = it.secondButtonTitle,
                    thirdButtonTitle = it.thirdButtonTitle,
                    onButtonClick = {
                        clickListener(it)
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

