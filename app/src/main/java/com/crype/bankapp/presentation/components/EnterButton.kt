package com.crype.bankapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.ui.theme.Blue
import com.crype.bankapp.ui.theme.BluePressed
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun EnterButton(
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp),
        colors = ButtonColors(
            containerColor = Blue,
            contentColor = Color.White,
            disabledContentColor = BluePressed,
            disabledContainerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp),
    ) {
        Text(
            text = label,
            fontSize = 20.sp,
            fontFamily = Typography.bodyLarge.fontFamily,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}