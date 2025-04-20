package com.example.myapplication.Views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmailView(){
    Text(modifier = Modifier.fillMaxSize().padding(20.dp), text = "Email")
}