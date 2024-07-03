package com.crype.bankapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _index = MutableStateFlow(0)
    val index: StateFlow<Int> get() = _index

    fun updateIndex(newIndex: Int) {
        _index.value = newIndex
    }
}