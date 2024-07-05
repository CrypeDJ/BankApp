package com.crype.bankapp.domain.usecases

import com.crype.bankapp.domain.usecases.transactions.GetAllTransactions
import com.crype.bankapp.domain.usecases.transactions.GetTransactionsByFilter
import com.crype.bankapp.domain.usecases.transactions.InsertTransaction

data class TransactionUseCases(
    val getAllTransactions: GetAllTransactions,
    val getTransactionsByFilter: GetTransactionsByFilter,
    val insertTransaction: InsertTransaction
)
