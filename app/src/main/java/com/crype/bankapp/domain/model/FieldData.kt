package com.crype.bankapp.domain.model

import androidx.compose.runtime.MutableState

data class FieldData(
    val title: String,
    val textField: MutableState<String>
)