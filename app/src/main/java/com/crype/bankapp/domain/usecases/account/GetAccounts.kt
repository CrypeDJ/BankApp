package com.crype.bankapp.domain.usecases.account

import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.domain.repository.AccountRepository
import kotlinx.coroutines.flow.Flow

class GetAccounts(private val accountRepository: AccountRepository) {
    operator fun invoke(): Flow<List<AccountEntity>> {
        return accountRepository.getAllAccounts()
    }
}