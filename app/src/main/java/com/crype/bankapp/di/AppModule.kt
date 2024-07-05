package com.crype.bankapp.di

import android.content.Context
import androidx.room.Room
import com.crype.bankapp.data.AppDatabase
import com.crype.bankapp.data.repository.AccountRepositoryImpl
import com.crype.bankapp.data.repository.TransactionRepositoryImpl
import com.crype.bankapp.domain.repository.AccountRepository
import com.crype.bankapp.domain.repository.TransactionRepository
import com.crype.bankapp.domain.usecases.AccountUseCases
import com.crype.bankapp.domain.usecases.TransactionUseCases
import com.crype.bankapp.domain.usecases.account.AddAccount
import com.crype.bankapp.domain.usecases.account.GetAccounts
import com.crype.bankapp.domain.usecases.transactions.GetAllTransactions
import com.crype.bankapp.domain.usecases.transactions.GetTransactionsByFilter
import com.crype.bankapp.domain.usecases.transactions.InsertTransaction
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTransactionsDatabase(@ApplicationContext application: Context): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "database.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTransactionRepository(database: AppDatabase): TransactionRepository {
        return TransactionRepositoryImpl(database.transactionDao)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(database: AppDatabase): AccountRepository {
        return AccountRepositoryImpl(database.accountDao)
    }

    @Provides
    @Singleton
    fun provideAccountUseCases(accountRepository: AccountRepository): AccountUseCases {
        return AccountUseCases(
            getAccounts = GetAccounts(accountRepository),
            addAccount = AddAccount(accountRepository)
        )
    }

    @Provides
    @Singleton
    fun provideTransactionUseCases(transactionRepository: TransactionRepository): TransactionUseCases {
        return TransactionUseCases(
            getAllTransactions = GetAllTransactions(transactionRepository),
            getTransactionsByFilter = GetTransactionsByFilter(transactionRepository),
            insertTransaction = InsertTransaction(transactionRepository)
        )
    }
}