package com.crype.bankapp.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.crype.bankapp.domain.model.FieldData
import com.crype.bankapp.domain.model.TransactionModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddTransactionViewModel : ViewModel() {
    private val _transactionInfo = MutableStateFlow<TransactionModel?>(null)
    val transactionInfo: StateFlow<TransactionModel?> get() = _transactionInfo

    private val _transactionInfoList = MutableStateFlow<List<FieldData>>(emptyList())
    val transactionInfoList: StateFlow<List<FieldData>> get() = _transactionInfoList

    init {
        val initialTransactions = listOf(
            FieldData("Transaction was applied in", mutableStateOf("")),
            FieldData("Transaction number", mutableStateOf("")),
            FieldData("Date", mutableStateOf("")),
            FieldData("Transaction status", mutableStateOf("")),
            FieldData("Amount", mutableStateOf(""))
        )
        _transactionInfoList.value = initialTransactions
    }

    fun updateTransaction(index: Int, value: String) {
        val updatedTransactions = _transactionInfoList.value.toMutableList()
        updatedTransactions[index] =
            updatedTransactions[index].copy(textField = mutableStateOf(value))
        _transactionInfoList.value = updatedTransactions
    }

    fun getTransactionInfo(transactionInfo: List<FieldData>) {
        val transactionInfoBuffer = TransactionModel()
        transactionInfoBuffer.senderName = transactionInfo[0].textField.value
        transactionInfoBuffer.transactionNumber = transactionInfo[1].textField.value
        transactionInfoBuffer.date = transactionInfo[2].textField.value
        transactionInfoBuffer.transactionStatus = transactionInfo[3].textField.value
        transactionInfoBuffer.money = transactionInfo[4].textField.value
        _transactionInfo.value = transactionInfoBuffer
    }
}