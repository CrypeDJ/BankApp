package com.crype.bankapp.data.repository

import com.crype.bankapp.data.dao.TransactionDao
import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date

class TransactionRepositoryImpl(private val transactionDao: TransactionDao) :
    TransactionRepository {
    override suspend fun insertTransaction(transaction: TransactionsEntity) =
        transactionDao.insertTransaction(transaction)

    override fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionsEntity>> =
        transactionDao.getAllTransactionOfAccount(accountId)

    override fun getTransactionsOfAccountByFilter(
        accountId: Int,
        startDate: Date,
        endDate: Date
    ): Flow<List<TransactionsEntity>> =
        transactionDao.getTransactionsOfAccountByFilter(accountId, startDate, endDate)
}