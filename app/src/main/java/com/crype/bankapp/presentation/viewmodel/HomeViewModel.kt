package com.crype.bankapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.usecases.AccountUseCases
import com.crype.bankapp.domain.usecases.TransactionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val accountUseCases: AccountUseCases,
    private val transactionUseCases: TransactionUseCases
) : ViewModel() {

    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> = _index.asStateFlow()

    private val _accounts = MutableStateFlow<List<AccountEntity>>(initialAccounts)
    val accounts: StateFlow<List<AccountEntity>> = _accounts

    private val _transactions = MutableStateFlow<List<TransactionsEntity>>(initialTransactions)
    val transactions: StateFlow<List<TransactionsEntity>> = _transactions

    init {
        loadAccounts()
        loadTransactions(_index.value)
    }

    fun updateIndex(newIndex: Int) {
        _index.value = newIndex
    }

    private fun loadAccounts() {
        viewModelScope.launch(Dispatchers.IO) {
            accountUseCases.getAccounts.invoke().collect { accountList ->
                if (accountList.isEmpty()) {
                    addInitialAccounts()
                } else {
                    _accounts.value = accountList
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun loadTransactions(accountId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            transactionUseCases.getAllTransactions.execute(accountId).collect { transactionList ->
                if (transactionList.isEmpty()) {
                    addInitialTransactions()
                } else {
                    _transactions.value = transactionList
                }
            }
        }
    }

    fun findAccountById(accountId: Int): AccountEntity {
        return if (_accounts.value.isNotEmpty()) _accounts.value[accountId]
        else _accounts.value[0]
    }

    private suspend fun addInitialAccounts() {
        initialAccounts.forEach { account ->
            accountUseCases.addAccount(account)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun addInitialTransactions() {
        initialTransactions.forEach { transaction ->
            transactionUseCases.insertTransaction(transaction)
        }
    }
}

