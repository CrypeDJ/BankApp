package com.crype.bankapp.domain.usecases

import com.crype.bankapp.domain.usecases.account.AddAccount
import com.crype.bankapp.domain.usecases.account.GetAccounts

data class AccountUseCases(
    val getAccounts: GetAccounts,
    val addAccount: AddAccount
)
