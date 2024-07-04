package com.crype.bankapp.data.repository

import com.crype.bankapp.data.dao.TransactionDao
import com.crype.bankapp.domain.model.TransactionModel
import com.crype.bankapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date

class TransactionRepositoryImpl(private val transactionDao: TransactionDao): TransactionRepository {
    override suspend fun insertTransaction(transaction: TransactionModel) =
        transactionDao.insertTransaction(transaction)

    override fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionModel>> =
        transactionDao.getAllTransactionOfAccount(accountId)

    override fun getTransactionsOfAccountByFilter(accountId: Int, startDate: Date, endDate: Date): Flow<List<TransactionModel>> =
        transactionDao.getTransactionsOfAccountByFilter(accountId, startDate, endDate)
}