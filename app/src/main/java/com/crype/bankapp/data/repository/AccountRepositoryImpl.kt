package com.crype.bankapp.data.repository

import com.crype.bankapp.data.dao.AccountDao
import com.crype.bankapp.domain.model.AccountModel
import com.crype.bankapp.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(private val accountDao: AccountDao) : AccountRepository {

    override fun getAllAccounts(): Flow<List<AccountModel>> = accountDao.getAllAccounts()
}