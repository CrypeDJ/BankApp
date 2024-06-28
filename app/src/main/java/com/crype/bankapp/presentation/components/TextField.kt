package com.crype.bankapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun TextField(title: String, text: String) {
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = Typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(width = 1.dp, color = Color.White),
            colors = CardDefaults.outlinedCardColors().copy(
                containerColor = Color.Transparent
            )
        ) {
            Text(
                text = if (title == "Amount") "\$" + text
                else text,
                fontSize = 16.sp,
                fontFamily = Typography.bodyMedium.fontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 12.dp)
            )
        }
    }
}