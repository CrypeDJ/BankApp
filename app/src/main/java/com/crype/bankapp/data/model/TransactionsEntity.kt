package com.crype.bankapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "transactions",
    indices = [Index("id")],
    foreignKeys = [
        ForeignKey(
            entity = AccountEntity::class,
            parentColumns = ["id"],
            childColumns = ["account_id"]
        )
    ]
)
data class TransactionsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "account_id") val accountId: Int,

    @ColumnInfo(name = "sender_name") val senderName: String,

    val date: Date,

    val status: String,

    val money: String,

    val number: String
)
