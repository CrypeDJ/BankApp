package com.crype.bankapp

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Window
import androidx.core.content.ContextCompat
import com.crype.bankapp.domain.TransactionModel
import com.crype.bankapp.presentation.screen.AddScreen
import com.crype.bankapp.presentation.screen.AllTransactionsScreen
import com.crype.bankapp.ui.theme.BankAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val w = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        enableEdgeToEdge()
        setContent {
            BankAppTheme {
                Box(modifier = Modifier.background(color = Color.Black).fillMaxSize()){
                    val transactionsModel: TransactionModel = TransactionModel()
                    AllTransactionsScreen(
                        transactionsNumber = 10,
                        transactionsModel = transactionsModel
                    )
                }

            }
        }
    }
}

