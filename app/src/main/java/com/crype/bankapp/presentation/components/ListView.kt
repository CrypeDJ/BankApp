package com.crype.bankapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.crype.bankapp.ui.theme.BackgroundCard

@Composable
fun ListView(
    itemsCount: Int,
    senderName: String,
    date: String,
    transactionProgress: String,
    money: String
) {
    LazyColumn(
        modifier = Modifier
            .background(color = BackgroundCard, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 15.dp),
    ) {
        items(itemsCount) {
            TransactionInfo(
                senderName = senderName,
                date = date,
                transactionProgress = transactionProgress,
                money = money
            )
        }
    }
}

