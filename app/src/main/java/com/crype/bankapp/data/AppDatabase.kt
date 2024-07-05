package com.crype.bankapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.crype.bankapp.data.dao.AccountDao
import com.crype.bankapp.data.dao.TransactionDao
import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.data.model.TransactionsEntity

@Database(
    entities = [
        AccountEntity::class,
        TransactionsEntity::class
    ],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val accountDao: AccountDao
    abstract val transactionDao: TransactionDao
}