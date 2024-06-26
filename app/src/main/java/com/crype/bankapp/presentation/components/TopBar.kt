package com.crype.bankapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.R
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun TopBar(
    //onBackClick:() -> Unit,
    //onFilterClick:() -> Unit,
    title: String
) {
    Row(
        modifier = Modifier
            .padding(vertical = 17.dp)
            .background(color = Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    //onBackClick()
                }
                .padding(start = 15.dp)
                .height(20.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = Typography.bodyLarge.fontFamily,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f),
            color = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.ellipsis_circle),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    //onFilterClick()
                }
                .padding(end = 15.dp)
        )
    }
}