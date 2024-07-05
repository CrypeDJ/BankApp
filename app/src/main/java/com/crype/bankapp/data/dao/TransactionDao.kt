package com.crype.bankapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.crype.bankapp.data.model.TransactionsEntity
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface TransactionDao {
    @Insert(entity = TransactionsEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaction(transaction: TransactionsEntity)

    @Query("SELECT * FROM transactions WHERE account_id = :accountId")
    fun getAllTransactionOfAccount(accountId: Int): Flow<List<TransactionsEntity>>

    @Query("SELECT * FROM transactions WHERE account_id = :accountId AND date BETWEEN :startDate AND :endDate")
    fun getTransactionsOfAccountByFilter(
        accountId: Int,
        startDate: Date,
        endDate: Date
    ): Flow<List<TransactionsEntity>>
}