package com.example.compose_bottom_sheet.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_bottom_sheet.ui.theme.ComposeBottomSheetTheme


@Composable
fun ButtonGroup(
    firstButtonTitle: String,
    secondButtonTitle: String,
    thirdButtonTitle: String,
    onButtonClick: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        TestButton(
            title = firstButtonTitle,
            color = MaterialTheme.colors.primary,
            onButtonClick = { onButtonClick(firstButtonTitle) }
        )
        TestButton(
            title = secondButtonTitle,
            color = MaterialTheme.colors.secondary,
            onButtonClick = { onButtonClick(secondButtonTitle) }
        )
        TestButton(
            title = thirdButtonTitle,
            color = MaterialTheme.colors.error,
            onButtonClick = { onButtonClick(thirdButtonTitle) }
        )
    }
}

@Composable
fun TestButton(title: String, color: Color, onButtonClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = color,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onButtonClick(title) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 8.dp),
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.surface
        )
    }

}


/**
 * ↓↓↓↓↓↓↓↓↓↓ Preview ↓↓↓↓↓↓↓↓↓↓↓↓
 * */

@Preview
@Composable
fun PreviewButtonGroup() {
    ComposeBottomSheetTheme {
        ButtonGroup(firstButtonTitle = "AAA", secondButtonTitle = "BBB", thirdButtonTitle = "CCC", onButtonClick = {})
    }
}

@Preview
@Composable
fun PreviewTestButton() {
    ComposeBottomSheetTheme {
        Column {
            TestButton(title = "AAA", color = MaterialTheme.colors.primary, onButtonClick = {})
            Spacer(modifier = Modifier.height(5.dp))
            TestButton(title = "BBB", color = MaterialTheme.colors.secondary, onButtonClick = {})
            Spacer(modifier = Modifier.height(5.dp))
            TestButton(title = "CCC", color = MaterialTheme.colors.error, onButtonClick = {})
        }
    }
}