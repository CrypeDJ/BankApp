package com.crype.bankapp.domain.repository

import com.crype.bankapp.domain.model.AccountModel
import kotlinx.coroutines.flow.Flow

interface AccountRepository{
    fun getAllAccounts(): Flow<List<AccountModel>>
}