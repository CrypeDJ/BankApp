package com.crype.bankapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.crype.bankapp.domain.model.TransactionModel
import com.crype.bankapp.navigation.NavGraph
import com.crype.bankapp.navigation.Screen
import com.crype.bankapp.presentation.screen.AllTransactionsScreen
import com.crype.bankapp.ui.theme.BankAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
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
                Box(
                    modifier = Modifier
                        .background(color = Color.Black)
                        .fillMaxSize()
                ) {
                    val navController = rememberNavController()
                   NavGraph(navController = navController, startDestination = Screen.HomeScreen.route)
                }
            }
        }
    }
}

