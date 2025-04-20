package com.example.myapplication.Views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Components.CircleNumber
import androidx.core.net.toUri
import com.example.myapplication.Components.formatPhoneNumber

@Preview
@Composable
fun PhomeView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally)
    {
        val items = listOf("1","2","3","4","5","6","7","8","9","*","0","#")
        var number by remember { mutableStateOf("") }
        val context = LocalContext.current
        val formattedNumber = formatPhoneNumber(number)

        Text(text = "phone", fontSize = 50.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = formattedNumber, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(10.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(3))
        {
            items(items) { item->
                CircleNumber(number = item){
                    if (number.count { it.isDigit() } < 11 && item.any { it.isDigit() }) {
                        number += item
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(){
            if (number != ""){

                Button(onClick = {
                    val intent = Intent(Intent.ACTION_DIAL, "tel:$number".toUri())
                    context.startActivity(intent)
                }){
                    Icon(imageVector = Icons.Default.Phone
                    , contentDescription = ""
                    , modifier = Modifier.size(30.dp))
                }
                Spacer(modifier = Modifier.width(40.dp))

                Button(onClick = {
                    number = number.dropLast(1)
                }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowLeft
                        , contentDescription = ""
                        , modifier = Modifier.size(30.dp))
                }
            }
        }

    }
}


