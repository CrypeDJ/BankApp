package com.crype.bankapp.domain.usecases.account

import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.domain.repository.AccountRepository

class AddAccount(private val accountRepository: AccountRepository) {
    suspend operator fun invoke(account: AccountEntity) {
        accountRepository.insertAccount(account)
    }
}