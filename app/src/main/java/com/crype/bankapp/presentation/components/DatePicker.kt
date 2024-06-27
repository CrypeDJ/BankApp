package com.crype.bankapp.presentation.components

import android.widget.CalendarView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.crype.bankapp.R
import com.crype.bankapp.ui.theme.Grey
import com.crype.bankapp.ui.theme.GreyCalendar
import com.crype.bankingapp.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerComponent(
    title: String,
    hint: String,
    borderColor: Color
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }
    var height by remember { mutableStateOf(0.dp) }
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontFamily = Typography.bodyMedium.fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.White,
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = it
                if (!expanded) height = 0.dp
            }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                value = selectedDate,
                onValueChange = {},
                readOnly = true,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = borderColor,
                    focusedBorderColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White,
                    disabledTextColor = Color.White,
                ),
                label = {
                    Text(
                        text = hint,
                        fontSize = 16.sp,
                        fontFamily = Typography.bodyMedium.fontFamily,
                        color = Grey
                    )
                },
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(color = Color.White, fontSize = 15.sp),
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Image(
                            painter = painterResource(id = R.drawable.calendar),
                            contentDescription = null
                        )
                    }
                }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                    height = 0.dp
                },
            ) {
                AndroidView(
                    factory = { context ->
                        CalendarView(context).apply {
                            dateTextAppearance = android.R.style.TextAppearance_Material_Medium
                            weekDayTextAppearance = android.R.style.TextAppearance_Material_Small
                            date = System.currentTimeMillis()
                            maxDate = System.currentTimeMillis()
                        }

                    },
                    modifier = Modifier
                        .background(GreyCalendar)
                        .fillMaxWidth()
                        .onGloballyPositioned { layoutCoordinates ->
                            val heightCal = layoutCoordinates.size.height
                        },
                    update = { calendarView ->
                        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                            val date = "$dayOfMonth.${month + 1}.$year"
                            selectedDate = date
                            expanded = false
                            height = 0.dp
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(height))
        }
    }
}

@Preview
@Composable
fun DatePickerPreview() {
    DatePickerComponent(title = "Start date", hint = "Select start date", Color.White)
}