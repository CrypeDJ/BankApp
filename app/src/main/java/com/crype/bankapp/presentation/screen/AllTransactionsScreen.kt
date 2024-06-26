package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crype.bankapp.domain.TransactionModel
import com.crype.bankapp.presentation.components.ListView
import com.crype.bankapp.presentation.components.TopBar

@Composable
fun AllTransactionsScreen(
    transactionsNumber: Int,
    transactionsModel: TransactionModel
) {
    Scaffold(
        topBar = { TopBar(title = "All transactions") },
        containerColor = Color.Black,
        modifier = Modifier
            .navigationBarsPadding()
            .statusBarsPadding()
            .fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .padding(horizontal = 15.dp)
                .padding(bottom = 50.dp)
        ) {
            ListView(
                itemsCount = transactionsNumber,
                senderName = transactionsModel.senderName,
                date = transactionsModel.date,
                transactionProgress = transactionsModel.transactionStatus,
                money = transactionsModel.money
            )
        }
    }
}

@Preview
@Composable
fun AllTransactionsScreenPreview() {
    val transactionsModel: TransactionModel = TransactionModel()
    AllTransactionsScreen(
        transactionsNumber = 10,
        transactionsModel = transactionsModel
    )
}