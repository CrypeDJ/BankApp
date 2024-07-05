package com.crype.bankapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.R
import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.ui.theme.Green
import com.crype.bankapp.ui.theme.Grey60
import com.crype.bankapp.ui.theme.Grey65
import com.crype.bankapp.ui.theme.Red
import com.crype.bankapp.ui.theme.Yellow
import com.crype.bankingapp.ui.theme.Typography


@Composable
fun TransactionInfo(
    transactionModel: TransactionsEntity,
    onItemClick: () -> Unit
) {
    val color: Color = when (transactionModel.status) {
        "Executed" -> Green
        "Declined" -> Red
        else -> Yellow
    }
    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 17.dp)
                .clickable { onItemClick() }
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = transactionModel.senderName,
                    fontSize = 20.sp,
                    fontFamily = Typography.bodyLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = transactionModel.date.toString(),
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                )
                Text(
                    text = transactionModel.status,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = color,
                )
            }
            Text(
                text = "\$" + transactionModel.money,
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
        HorizontalDivider(
            color = Grey65,
            thickness = 0.5.dp
        )
    }
}