package com.crype.bankapp.domain.repository

import com.crype.bankapp.data.model.TransactionsEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

interface TransactionRepository {

    suspend fun insertTransaction(transaction: TransactionsEntity)

    fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionsEntity>>

    fun getTransactionsOfAccountByFilter(
        accountId: Int,
        startDate: Date,
        endDate: Date
    ): Flow<List<TransactionsEntity>>
}