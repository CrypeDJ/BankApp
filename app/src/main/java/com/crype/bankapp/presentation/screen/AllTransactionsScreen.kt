package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.crype.bankapp.presentation.components.ListView
import com.crype.bankapp.presentation.components.TopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTransactionsScreen(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    Scaffold(
        topBar = {
            TopBar(
                title = "All transactions",
                onFilterClick = {
                    scope.launch {
                        sheetState.show()
                    }
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        },
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
                navController = navController
            )
        }
    }
    if (sheetState.isVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                scope.launch {
                    sheetState.hide()
                }
            },
            sheetState = sheetState,
            containerColor = Color.Black,
            modifier = Modifier.fillMaxHeight()
        ) {
            FilterScreen(
                onFilterChoose = { startDate, endDate ->
                    scope.launch {
                        sheetState.hide()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun AllTransactionsScreenPreview() {
    AllTransactionsScreen(
        navController = rememberNavController()
    )
}