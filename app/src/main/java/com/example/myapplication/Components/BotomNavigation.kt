package com.example.myapplication.Components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.Navigation.Routes

@Composable
fun BottomNav(navHostController: NavController, routes: List<Routes>){
    BottomAppBar {
        NavigationBar (){
            val currentRoute = CurrentRoute(navHostController)
            routes.forEach{item->
                NavigationBarItem(selected = currentRoute == item.route, onClick = {
                    navHostController.navigate(item.route)},
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title, tint = Color.Blue) },
                    label = { Text(text = item.title) },
                    alwaysShowLabel = false)
            }
        }
    }
}

@Composable
fun CurrentRoute(navHostController: NavController): String?{
    val current by navHostController.currentBackStackEntryAsState()
    return  current?.destination?.route
}