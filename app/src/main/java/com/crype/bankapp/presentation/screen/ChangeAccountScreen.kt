package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.domain.model.AccountModel
import com.crype.bankapp.presentation.components.AccountName
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun ChangeAccountScreen(
    accountList: List<AccountModel>,
    onSelectClick: (index: Int) -> Unit
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
                items(accountList.size) { item ->
                    AccountName(
                        accountModel = accountList[item],
                        onClick = {
                            onSelectClick(item)
                        },
                        isShowArrow = false
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
            }
        }
    }
}