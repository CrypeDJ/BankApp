package com.crype.bankapp.domain

data class TransactionModel(
    val senderName:String = "OOO “Company”",
    val date: String = "01.06.2024",
    val transactionStatus:String ="Executed",
    val money: String = "10.09"
)
