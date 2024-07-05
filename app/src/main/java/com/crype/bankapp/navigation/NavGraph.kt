package com.crype.bankapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.crype.bankapp.presentation.screen.AddScreen
import com.crype.bankapp.presentation.screen.AllTransactionsScreen
import com.crype.bankapp.presentation.screen.HomeScreen
import com.crype.bankapp.presentation.screen.TransactionInfoScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.AddScreen.route,
            arguments = listOf(navArgument("accountId") {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val accountId = backStackEntry.arguments?.getInt("accountId")
            if (accountId != null) {
                AddScreen(navController = navController, accountId = accountId)
            }
        }
        composable(route = Screen.AllTransactionsScreen.route) {
            AllTransactionsScreen(navController = navController)
        }
        composable(
            route = Screen.TransactionInfoScreen.route,
            arguments = listOf(navArgument("transaction") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val transaction = backStackEntry.arguments?.getString("transaction")
            if (transaction != null) {
                TransactionInfoScreen(navController = navController, transaction)
            }
        }
    }

}