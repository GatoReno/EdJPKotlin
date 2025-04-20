package com.example.myapplication.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PhomeView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.Start)
    {
        Text(text = "phone", fontSize = 50.sp, fontWeight = FontWeight.Bold )
        Spacer(modifier = Modifier.height(10.dp))
        val items = listOf("1","2","3","4","5","6","7","8","9","*","0","#")
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(items) { item->
                Text(text = item)
            }
        }

    }
}


