package com.example.myapplication.Views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.myapplication.Components.formatPhoneNumber

@Preview
@Composable
fun SmsView(){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var number by remember { mutableStateOf("") }
        var msn by remember {  mutableStateOf("") }
        val context = LocalContext.current
        val formattedNumber = formatPhoneNumber(number)

        Text(modifier = Modifier.padding(20.dp),text = "Sms",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold)

        OutlinedTextField(value = number,
            onValueChange = {newValue ->
                val digits = newValue.filter { it.isDigit() }
                if (digits.length <= 11) {
                    number = digits
                }
                            },
            label = {Text(text = "Number")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(10.dp))

        OutlinedTextField(value = msn,
            onValueChange = {msn = it},
            label = {Text(text = "Message")},
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp))

        Spacer(modifier = Modifier.width(40.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = "smsto:${number}".toUri()
            context.startActivity(intent)
        }) { Text(text = "Send") }

    }

}