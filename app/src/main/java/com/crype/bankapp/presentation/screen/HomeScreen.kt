package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.domain.model.AccountModel
import com.crype.bankapp.domain.model.TransactionModel
import com.crype.bankapp.presentation.components.AccountName
import com.crype.bankapp.presentation.components.ListView
import com.crype.bankapp.ui.theme.Blue
import com.crype.bankingapp.ui.theme.Typography
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    accountModel: AccountModel,
    transactionModel: TransactionModel,
    itemsCount: Int,
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .padding(start = 17.dp, end = 17.dp, top = 25.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 15.dp),
                text = "Account",
                fontFamily = Typography.bodyLarge.fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 30.sp
            )
            AccountName(
                accountName = accountModel.accountName,
                numberOfAccount = accountModel.numberOfAccount,
                lastNumbersOfCard = "•••• " + accountModel.lastNumbersOfCard,
                isShowArrow = true,
                onClick = {
                    scope.launch {
                        sheetState.show()
                    }
                }
            )
            Row {
                Text(
                    modifier = Modifier
                        .padding(vertical = 15.dp)
                        .weight(1f),
                    text = "Recent Transactions",
                    fontFamily = Typography.bodyLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 25.sp
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable { },
                    text = "VIEW ALL",
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Blue,
                    fontSize = 15.sp
                )
            }
            ListView(
                itemsCount = itemsCount,
                senderName = transactionModel.senderName,
                date = transactionModel.date,
                transactionProgress = transactionModel.transactionStatus,
                money = transactionModel.money
            )

        }
        FloatingActionButton(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            containerColor = Blue,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 17.dp, bottom = 50.dp)
        ) {
            androidx.compose.material3.Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .height(30.dp)
                    .width(30.dp)
            )
        }
        if (sheetState.isVisible) {
            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch {
                        sheetState.hide()
                    }
                },
                sheetState = sheetState,
                containerColor = Color.Black
            ) {
                ChangeAccountScreen(
                    accountAmount = 3,
                    accountModel = AccountModel(),
                    scope = scope,
                    sheetState = sheetState
                )
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        transactionModel = TransactionModel(),
        accountModel = AccountModel(),
        itemsCount = 4
    )
}