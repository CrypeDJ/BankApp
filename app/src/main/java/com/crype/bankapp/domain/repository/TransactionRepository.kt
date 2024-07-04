package com.crype.bankapp.domain.repository

import com.crype.bankapp.domain.model.TransactionModel
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TransactionRepository{
    suspend fun insertTransaction(transaction: TransactionModel)
    fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionModel>>
    fun getTransactionsOfAccountByFilter(accountId: Int, startDate: Date, endDate: Date): Flow<List<TransactionModel>>
}