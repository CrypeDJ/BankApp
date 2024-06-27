package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.presentation.components.DatePickerComponent
import com.crype.bankapp.presentation.components.EnterButton
import com.crype.bankapp.ui.theme.Grey65
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun FilterScreen() {
    val names = listOf(
        "Start date",
        "End date"
    )
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Text(
                text = "Select the account",
                fontSize = 30.sp,
                fontFamily = Typography.bodyLarge.fontFamily,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
            )
            LazyColumn {
                items(2) { index ->
                    DatePickerComponent(
                        title = names[index],
                        hint = if (names[index] == "Start date") "Select start date"
                        else "Select end date",
                        Color.White
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(top = 10.dp),
                color = Grey65
            )
            EnterButton(label = "Submit")
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
fun FilterScreenPreview() {
    FilterScreen()
}