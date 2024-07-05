package com.crype.bankapp.domain.usecases.transactions

import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.repository.TransactionRepository

class InsertTransaction(private val transactionRepository: TransactionRepository) {
    suspend operator fun invoke(transaction: TransactionsEntity) {
        return transactionRepository.insertTransaction(transaction)
    }
}