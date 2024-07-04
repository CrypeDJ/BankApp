package com.crype.bankapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.model.TransactionModel
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface TransactionDao {
    @Insert(entity = TransactionsEntity::class)
    fun insertTransaction(transaction: TransactionModel)

    @Query("SELECT * FROM transactions WHERE account_id = :accountId")
    fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionModel>>

    @Query("SELECT * FROM transactions WHERE account_id = :accountId AND date BETWEEN :startDate AND :endDate")
    fun getTransactionsOfAccountByFilter(accountId: Int, startDate: Date, endDate: Date): Flow<List<TransactionModel>>
}