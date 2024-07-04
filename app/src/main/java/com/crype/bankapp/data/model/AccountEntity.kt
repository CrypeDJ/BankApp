package com.crype.bankapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "accounts"
)
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val accountName: String,
    @ColumnInfo(name = "number") val accountNumber: String,
    @ColumnInfo(name = "card_number") val lastCardNumbers: String,
)
