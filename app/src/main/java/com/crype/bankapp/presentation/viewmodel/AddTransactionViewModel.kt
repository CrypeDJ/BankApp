package com.crype.bankapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crype.bankapp.data.model.TransactionsEntity
import com.crype.bankapp.domain.usecases.TransactionUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val transactionUseCases: TransactionUseCases
) : ViewModel() {

    private val _transactionInfo = MutableStateFlow(
        TransactionsEntity(
            id = 0,
            accountId = 0,
            senderName = "",
            date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
            status = "",
            money = "",
            number = ""
        )
    )

    fun insertTransaction(accountId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val updatedTransaction = _transactionInfo.value.copy(
                accountId = _transactionInfo.value.accountId
            )
            _transactionInfo.value = updatedTransaction
            transactionUseCases.insertTransaction.invoke(_transactionInfo.value)
        }
    }

    fun updateTransaction(index: Int, value: String) {
        val updatedTransaction = _transactionInfo.value.copy(
            senderName = if (index == 0) value else _transactionInfo.value.senderName,
            number = if (index == 1) value else _transactionInfo.value.number,
            status = if (index == 2) value else _transactionInfo.value.status,
            money = if (index == 3) value else _transactionInfo.value.money
        )
        _transactionInfo.value = updatedTransaction
    }
}