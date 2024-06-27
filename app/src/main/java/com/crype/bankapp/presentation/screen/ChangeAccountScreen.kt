package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.domain.model.AccountModel
import com.crype.bankapp.presentation.components.AccountName
import com.crype.bankingapp.ui.theme.Typography
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeAccountScreen(
    accountAmount: Int,
    accountModel: AccountModel,
    scope: CoroutineScope,
    sheetState: SheetState
) {
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(horizontal = 15.dp)) {
            Text(
                text = "Select the account",
                fontSize = 30.sp,
                fontFamily = Typography.bodyLarge.fontFamily,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 20.dp)
            )
            LazyColumn {
                items(accountAmount) {
                    AccountName(
                        accountName = accountModel.accountName,
                        numberOfAccount = accountModel.numberOfAccount,
                        lastNumbersOfCard = "•••• " + accountModel.lastNumbersOfCard,
                        onClick = {
                            scope.launch {
                                sheetState.hide()
                            }
                        },
                        isShowArrow = false
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}