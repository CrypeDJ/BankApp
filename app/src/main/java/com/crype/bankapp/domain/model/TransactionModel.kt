package com.crype.bankapp.domain.model

data class TransactionModel(
    var senderName: String = "OOO “Company”",
    var date: String = "01.06.2024",
    var transactionStatus: String = "Executed",
    var money: String = "10.09",
    var transactionNumber: String = "f4345jfshjek3454"
)

val transactionList = listOf(
    TransactionModel("OOO “Company”", "01.06.2024", "Executed", "10.09", "f4345jfshjek3454"),
    TransactionModel("OOO “Company”", "01.06.2024", "Declined", "10.09", "6453653654363466"),
    TransactionModel("OOO “Company”", "01.06.2024", "Executed", "10.09", "4b536ttgb5tytby5"),
    TransactionModel("OOO “Company”", "01.06.2024", "Declined", "10.09", "yb5y5yb56y54b5b5"),
)
