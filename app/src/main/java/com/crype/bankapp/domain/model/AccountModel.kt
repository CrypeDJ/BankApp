package com.crype.bankapp.domain.model

data class AccountModel(
    val accountName: String,
    val numberOfAccount: String,
    val lastNumbersOfCard: String
)

val accountList = listOf(
    AccountModel("Name 1", "81237598213759", "1234"),
    AccountModel("Name 2", "32598347532759", "7545"),
    AccountModel("Name 3", "12571257238583", "0435")
)
