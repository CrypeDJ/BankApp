package com.crype.bankapp.presentation.screen

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.crype.bankapp.navigation.Screen
import com.crype.bankapp.presentation.components.AccountName
import com.crype.bankapp.presentation.components.ListView
import com.crype.bankapp.presentation.viewmodel.HomeViewModel
import com.crype.bankapp.ui.theme.Blue
import com.crype.bankingapp.ui.theme.Typography
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val index = homeViewModel.index.collectAsState().value
    val accounts = homeViewModel.accounts.collectAsState().value
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
                accountModel = homeViewModel.findAccountById(index),
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
                        .clickable { navController.navigate(route = Screen.AllTransactionsScreen.route) },
                    text = "VIEW ALL",
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Blue,
                    fontSize = 15.sp
                )
            }
            ListView(
                navController = navController,
                false
            )
        }
        FloatingActionButton(
            onClick = { navController.navigate(route = Screen.AddScreen.createRoute(index)) },
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
                    accountList = accounts,
                    onSelectClick = { index ->
                        homeViewModel.updateIndex(index)
                        scope.launch {
                            sheetState.hide()
                        }
                    }
                )
            }
        }
    }
}