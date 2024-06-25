package com.crype.bankapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.bankapp.R
import com.crype.bankapp.presentation.components.ListView
import com.crype.bankapp.ui.theme.BackgroundCard
import com.crype.bankapp.ui.theme.Blue
import com.crype.bankapp.ui.theme.Grey60
import com.crype.bankingapp.ui.theme.Typography

@Composable
fun HomeScreen(
    accountName: String,
    numberOfAccount:String,
    lastNumbersOfCard: String,
    senderName: String,
    date: String,
    transactionProgress: String,
    money: String,
    itemsCount: Int

){  Box(
    modifier = Modifier
        .background(color = Color.Black)
        .fillMaxSize()

){
    Column (
        modifier =Modifier
            .padding(start = 17.dp,end=17.dp,top=25.dp)
    ){
        Text(
            modifier = Modifier.padding(vertical = 15.dp),
            text = "Account",
            fontFamily = Typography.bodyLarge.fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 30.sp
        )
        AccountName(accountName = accountName, numberOfAccount = numberOfAccount, lastNumbersOfCard = lastNumbersOfCard)
        Row {
            Text(
                modifier = Modifier
                    .padding(vertical = 15.dp)
                    .weight(1f),
                text = "Recent Transactions",
                fontFamily = Typography.bodyLarge.fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 25.sp
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .clickable { },
                text = "VIEW ALL",
                fontFamily = Typography.bodyMedium.fontFamily,
                fontWeight = FontWeight.Normal,
                color = Blue,
                fontSize = 15.sp
            )
        }
        ListView(itemsCount = itemsCount, senderName = senderName, date = date, transactionProgress = transactionProgress, money = money)

    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        containerColor = Blue,
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 17.dp, bottom = 50.dp)
    ) {
       androidx.compose.material3.Icon(
           imageVector = Icons.Filled.Add,
           contentDescription = "",
           tint = Color.White,
           modifier = Modifier
               .height(30.dp)
               .width(30.dp)
       )
    }
}

}






@Composable
fun AccountName(
    accountName: String,
    numberOfAccount:String,
    lastNumbersOfCard: String
){

    Box(
        modifier = Modifier
            .background(color = BackgroundCard, shape = RoundedCornerShape(16.dp))
            .padding(10.dp),
        ) {
        Row (
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 5.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.card),
                contentDescription = "Card",

            )
            Column (
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = accountName,
                    fontSize = 16.sp,
                    fontFamily = Typography.bodyLarge.fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text(
                    text = numberOfAccount,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                Text(
                    text = lastNumbersOfCard,
                    fontSize = 14.sp,
                    fontFamily = Typography.bodyMedium.fontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Grey60,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.arrow_forward_grey),
                contentDescription = "forward",
                modifier = Modifier
                    .height(18.dp)
                    .align(Alignment.CenterVertically),
                alpha = 0.6f,

            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview (){
    HomeScreen(
        accountName = "Saving account",
        numberOfAccount = "32509235032",
        lastNumbersOfCard = "•••• 1234",
        senderName = "OOO “Company”",
        date = "01.02.2003",
        transactionProgress = "Executed",
        money = "10.09",
        itemsCount = 4)
}