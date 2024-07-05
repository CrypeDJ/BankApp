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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.crype.bankapp.presentation.components.EnterButton
import com.crype.bankapp.presentation.components.TextField
import com.crype.bankapp.presentation.viewmodel.HomeViewModel
import com.crype.bankingapp.ui.theme.Typography

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TransactionInfoScreen(
    navController: NavController,
    transactionNumber: String,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val transaction =
        homeViewModel.transactions.collectAsState().value.find { it.number == transactionNumber }
    val fields = listOf(
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
            Column(
                modifier = Modifier.imePadding()
            ) {
                fields.forEach { label ->
                    if (transaction != null) {
                        TextField(
                            title = label,
                            text = when (label) {
                                "Transaction was applied in" -> transaction.senderName
                                "Transaction number" -> transaction.number
                                "Transaction status" -> transaction.status
                                else -> transaction.money
                            }
                        )
                    }
                }
            }
            EnterButton(label = "Okay", onClick = { navController.popBackStack() })
        }
    }
}