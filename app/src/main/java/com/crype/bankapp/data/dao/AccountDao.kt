package com.crype.bankapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.crype.bankapp.domain.model.AccountModel
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM accounts")
    fun getAllAccounts(): Flow<List<AccountModel>>
}