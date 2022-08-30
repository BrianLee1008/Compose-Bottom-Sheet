@file:OptIn(ExperimentalMaterialApi::class)
package com.example.compose_bottom_sheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import com.example.compose_bottom_sheet.state.content
import com.example.compose_bottom_sheet.state.rememberAlphabetSortBottomSheetStateHolder
import com.example.compose_bottom_sheet.state.rememberButtonUiStateHolder
import com.example.compose_bottom_sheet.ui.theme.ComposeBottomSheetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomSheetTheme {

                BottomSheetScaffold(sheetContent = content) {
                    Screen(
                        buttonUiStateHolder = rememberButtonUiStateHolder(),
                        alphabetSortBottomSheetStateHolder = rememberAlphabetSortBottomSheetStateHolder()
                    )
                }
            }
        }
    }
}
