package com.crype.bankapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import com.crype.bankapp.data.model.AccountEntity
import com.crype.bankapp.data.model.TransactionsEntity
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date

val initialAccounts = listOf(
    AccountEntity(
        id = 1,
        accountName = "Salary",
        accountNumber = "frfre45et54y",
        lastCardNumbers = "1234"
    ),
    AccountEntity(
        id = 2,
        accountName = "Procents",
        accountNumber = "j7rtyj76r54r",
        lastCardNumbers = "7772"
    ),
)

@RequiresApi(Build.VERSION_CODES.O)
val initialTransactions = listOf(
    TransactionsEntity(
        id = 1,
        accountId = 1,
        senderName = "Bond",
        date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
        status = "Declined",
        money = "10.00",
        number = "5325"
    )
)

