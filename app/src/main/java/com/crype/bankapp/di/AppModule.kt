package com.crype.bankapp.di

import androidx.room.Room
import com.crype.bankapp.data.AppDatabase
import com.crype.bankapp.data.repository.AccountRepositoryImpl
import com.crype.bankapp.data.repository.TransactionRepositoryImpl
import com.crype.bankapp.domain.repository.AccountRepository
import com.crype.bankapp.domain.repository.TransactionRepository
import com.crype.bankapp.presentation.viewmodel.AddTransactionViewModel
import com.crype.bankapp.presentation.viewmodel.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "database.db"
        )
    }
    single { get<AppDatabase>().accountDao() }
    single { get<AppDatabase>().transactionDao() }
    single<AccountRepository> { AccountRepositoryImpl(get()) }
    single<TransactionRepository> { TransactionRepositoryImpl(get()) }
    viewModel { AddTransactionViewModel() }
    viewModel { HomeViewModel() }
}

