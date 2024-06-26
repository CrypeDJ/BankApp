package com.crype.bankapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.R
import com.crype.bankapp.ui.theme.Green
import com.crype.bankapp.ui.theme.Grey60
import com.crype.bankapp.ui.theme.Grey65
import com.crype.bankapp.ui.theme.Red
import com.crype.bankapp.ui.theme.Yellow
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun TransactionInfo(
    senderName: String,
    date: String,
    transactionProgress: String,
    money: String
) {
    val color: Color = when (transactionProgress) {
        "Executed" -> Green
        "Declined" -> Red
        else -> Yellow
    }
    Column {
        Row(
            modifier = Modifier.padding(vertical = 17.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = senderName,
                    fontSize = 20.sp,
                    fontFamily = Typography.bodyLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = date,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                )
                Text(
                    text = transactionProgress,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = color,
                )
            }
            Text(
                text = "\$$money",
                fontSize = 18.sp,
                fontFamily = Typography.bodyMedium.fontFamily,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_forward_grey),
                contentDescription = "to transaction",
                alpha = 0.3f,
                modifier = Modifier.height(25.dp)
            )
        }
        Divider(
            color = Grey65,
            thickness = 0.5.dp
        )
    }
}