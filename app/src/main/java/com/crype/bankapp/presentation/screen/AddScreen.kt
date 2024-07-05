package com.crype.bankapp.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.crype.bankapp.navigation.Screen
import com.crype.bankapp.presentation.components.EnterButton
import com.crype.bankapp.presentation.components.EnterField
import com.crype.bankapp.presentation.viewmodel.AddTransactionViewModel
import com.crype.bankingapp.ui.theme.Typography

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddScreen(
    navController: NavController,
    accountId: Int,
    addTransactionViewModel: AddTransactionViewModel = hiltViewModel()
) {
    val transactionInfoList = listOf(
        "Transaction was applied in",
        "Transaction number",
        "Transaction status",
        "Amount"
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .imePadding()
        ) {
            Text(
                text = "Transaction",
                fontFamily = Typography.bodyLarge.fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = Color.White,
                modifier = Modifier.padding(vertical = 40.dp)
            )
            LazyColumn(
                modifier = Modifier.imePadding()
            ) {
                itemsIndexed(transactionInfoList) { index, transaction ->
                    EnterField(
                        title = transaction,
                        keyboardType = when (transaction) {
                            "Amount", "Date" -> KeyboardType.Number
                            else -> KeyboardType.Text
                        },
                        onValueChange = { newValue ->
                            addTransactionViewModel.updateTransaction(index, newValue)
                        }
                    )
                }
            }
            EnterButton(
                label = "Okay",
                onClick = {
                    addTransactionViewModel.insertTransaction(accountId)
                    navController.navigate(route = Screen.HomeScreen.route)
                }
            )
        }
    }
}
