package com.example.compose_bottom_sheet.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_bottom_sheet.R
import com.example.compose_bottom_sheet.state.AlphabetSortUiState
import com.example.compose_bottom_sheet.ui.theme.ComposeBottomSheetTheme

@Composable
fun AlphabetSortBottomSheet(
    sheetTitle: String,
    list: List<AlphabetSortUiState>,
    selectedItem: (item: String, number: String) -> Unit,
    hideBottomSheet: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.onSurface)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Title(title = sheetTitle, onCloseClick = hideBottomSheet)

        list.forEach {
            Row(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 20.dp,
                        bottom = 20.dp
                    )
                    .clickable {
                        hideBottomSheet()
                        selectedItem(it.name, it.number)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = it.name,
                    color = MaterialTheme.colors.surface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = it.number,
                    color = MaterialTheme.colors.surface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
    }
}

@Composable
fun Title(
    title: String,
    onCloseClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(18.dp, 18.dp)
            .fillMaxWidth()
            .clickable {
                onCloseClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title.uppercase(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primaryVariant
        )

        Image(
            painter = painterResource(id = R.drawable.ic_baseline_close_24),
            contentDescription = ""
        )
    }
}

/**
 * ↓↓↓↓↓↓↓↓↓↓ Preview ↓↓↓↓↓↓↓↓↓↓↓↓
 * */

@Preview
@Composable
fun PreviewAlphabetSortBottomSheet() {
    val list = listOf(
        AlphabetSortUiState("A-1", "01"),
        AlphabetSortUiState("A-2", "02"),
        AlphabetSortUiState("A-3", "03"),
        AlphabetSortUiState("A-4", "04"),
        AlphabetSortUiState("A-5", "05")
    )
    ComposeBottomSheetTheme {
        AlphabetSortBottomSheet(
            sheetTitle = "AAA",
            list = list,
            selectedItem = { _, _ -> },
            hideBottomSheet = {}
        )
    }
}