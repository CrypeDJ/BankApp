package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.presentation.components.DatePickerComponent
import com.crype.bankapp.presentation.components.EnterButton
import com.crype.bankapp.ui.theme.ErrorRed
import com.crype.bankapp.ui.theme.Grey65
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun FilterScreen(
    onFilterChoose: (dateStart: String?, dateEnd: String?) -> Unit
) {
    var startDate by remember {
        mutableStateOf("")
    }
    var endDate by remember {
        mutableStateOf("")
    }
    var borderColor by remember {
        mutableStateOf(Color.White)
    }
    Box(
        modifier = Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Text(
                text = "Select the account",
                fontSize = 30.sp,
                fontFamily = Typography.bodyLarge.fontFamily,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
            )
            DatePickerComponent(
                title = "Start date",
                hint = "Select start date",
                borderColor = borderColor,
                onDatePicked = { value ->
                    startDate = value
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            DatePickerComponent(
                title = "End date",
                hint = "Select end date",
                borderColor = borderColor,
                onDatePicked = { value ->
                    endDate = value
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            HorizontalDivider(
                thickness = 1.dp,
                modifier = Modifier.padding(top = 10.dp),
                color = Grey65
            )
            EnterButton(label = "Submit", onClick = {
                if (endDate.isEmpty() && startDate.isEmpty()) {
                    borderColor = ErrorRed
                } else {
                    onFilterChoose(startDate, endDate)
                }
            })
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}