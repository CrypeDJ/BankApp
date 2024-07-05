package com.crype.bankapp.navigation

sealed class Screen(val route: String) {
    object AddScreen : Screen(route = "add_screen/{accountId}") {
        fun createRoute(accountId: Int) = "add_screen/$accountId"
    }

    object AllTransactionsScreen : Screen(route = "all_transactions_screen")
    object HomeScreen : Screen(route = "home_screen")
    object TransactionInfoScreen : Screen(route = "transaction_info_screen/{transaction}") {
        fun createRoute(transaction: String) = "transaction_info_screen/$transaction"
    }
}