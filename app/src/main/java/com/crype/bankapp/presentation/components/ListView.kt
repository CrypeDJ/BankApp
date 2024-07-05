package com.crype.bankapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.crype.bankapp.navigation.Screen
import com.crype.bankapp.presentation.viewmodel.HomeViewModel
import com.crype.bankapp.ui.theme.BackgroundCard

@Composable
fun ListView(
    navController: NavController,
    isAllTransactions: Boolean
) {
    val homeViewModel: HomeViewModel = viewModel()
    val transactions = homeViewModel.transactions.collectAsState().value
    LazyColumn(
        modifier = Modifier
            .background(color = BackgroundCard, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 15.dp)
            .wrapContentHeight(),
    ) {
        items(
            if (isAllTransactions) transactions
            else transactions.takeLast(4)
        ) { transaction ->
            TransactionInfo(
                transactionModel = transaction,
                onItemClick = {
                    navController.navigate(
                        route = Screen.TransactionInfoScreen.createRoute(
                            transaction.number
                        )
                    )
                }
            )
        }
    }
}

