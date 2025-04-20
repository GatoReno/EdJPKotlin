package com.example.myapplication.Views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Components.BottomNav
import com.example.myapplication.Navigation.NavManager
import com.example.myapplication.Navigation.Routes

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.PhoneView,
        Routes.SmsView,
        Routes.EmailView)
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNav(navController,navigationRoutes)
        }
    ){
        NavManager(navController)
    }
}