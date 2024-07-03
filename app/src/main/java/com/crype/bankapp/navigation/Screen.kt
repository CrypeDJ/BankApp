package com.crype.bankapp.navigation

sealed class Screen(val route: String) {
    data object AddScreen : Screen(route = "add_screen")
    data object AllTransactionsScreen : Screen(route = "all_transactions_screen")
    data object HomeScreen : Screen(route = "home_screen")
    data object TransactionInfoScreen : Screen(route = "transaction_info_screen/{transaction}") {
        fun createRoute(transaction: String) = "transaction_info_screen/$transaction"
    }
}