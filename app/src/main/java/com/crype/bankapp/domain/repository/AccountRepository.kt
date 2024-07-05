package com.crype.bankapp.domain.repository

import com.crype.bankapp.data.model.AccountEntity
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAllAccounts(): Flow<List<AccountEntity>>

    suspend fun insertAccount(account: AccountEntity)
}