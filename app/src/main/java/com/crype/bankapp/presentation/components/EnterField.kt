package com.crype.bankapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun EnterField(title: String, keyboardType: KeyboardType) {

    val (titleValue, setTitle) = remember { mutableStateOf("") }
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = Typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        OutlinedTextField(
            value = titleValue,
            onValueChange = setTitle,
            enabled = true,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = keyboardType,
            ),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedBorderColor = Color.White,
                focusedBorderColor = Color.White,
                cursorColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedTextColor = Color.White,
                disabledTextColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp),
            shape = RoundedCornerShape(16.dp),
            textStyle = LocalTextStyle.current.merge(
                fontSize = 16.sp,
                fontFamily = Typography.bodyMedium.fontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
            ),
        )
    }
}