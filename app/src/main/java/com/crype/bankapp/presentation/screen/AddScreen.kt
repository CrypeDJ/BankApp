package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.presentation.components.EnterButton
import com.crype.bankapp.presentation.components.EnterField
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun AddScreen() {
    val fields = listOf(
        "Transaction was applied in",
        "Transaction number",
        "Date",
        "Transaction status",
        "Amount"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .imePadding()
        ) {
            Text(
                text = "Transaction",
                fontFamily = Typography.bodyLarge.fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 40.dp)
            )
            LazyColumn(
                modifier = Modifier.imePadding()
            ) {
                items(fields.size) {

                    EnterField(
                        title = fields[it],
                        keyboardType = when (fields[it]) {
                            "Amount", "Date" -> KeyboardType.Number
                            else -> KeyboardType.Text
                        }
                    )
                }
            }
            EnterButton(label = "Okey")
        }
    }
}

@Preview
@Composable
fun AddScreenPreview() {
    AddScreen()
}