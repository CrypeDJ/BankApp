package com.crype.bankapp.domain.usecases.transactions

import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetAllTransactions(private val transactionRepository: TransactionRepository) {
    fun execute(accountId: Int): Flow<List<TransactionsEntity>> {
        return transactionRepository.getAllTransactionOfAccount(accountId)
    }
}