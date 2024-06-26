package com.crype.bankapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.R
import com.crype.bankapp.ui.theme.BackgroundCard
import com.crype.bankapp.ui.theme.Grey60
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun AccountName(
    accountName: String,
    numberOfAccount: String,
    lastNumbersOfCard: String
) {

    Box(
        modifier = Modifier
            .background(color = BackgroundCard, shape = RoundedCornerShape(16.dp))
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 5.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = "Card",

                )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = accountName,
                    fontSize = 16.sp,
                    fontFamily = Typography.bodyLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = numberOfAccount,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                Text(
                    text = lastNumbersOfCard,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.arrow_forward_grey),
                contentDescription = "forward",
                modifier = Modifier
                    .height(18.dp)
                    .align(Alignment.CenterVertically),
                alpha = 0.6f,

                )
        }
    }
}