package com.crype.bankapp.domain.usecases.transactions

import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.util.Date

class GetTransactionsByFilter(private val transactionRepository: TransactionRepository) {
    fun execute(accountId: Int, startDate: Date, endDate: Date): Flow<List<TransactionsEntity>> {
        return transactionRepository.getTransactionsOfAccountByFilter(accountId, startDate, endDate)
    }
}