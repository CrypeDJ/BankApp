package com.crype.bankapp.data.repository

import com.crype.bankapp.data.dao.AccountDao
import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class AccountRepositoryImpl(private val accountDao: AccountDao) : AccountRepository {

    override fun getAllAccounts(): Flow<List<AccountEntity>> = accountDao.getAllAccounts()

    override suspend fun insertAccount(account: AccountEntity) {
        accountDao.insertAccount(account)
    }
}