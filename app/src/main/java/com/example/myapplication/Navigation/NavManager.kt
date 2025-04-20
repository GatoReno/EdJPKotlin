package com.example.myapplication.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.Views.EmailView
import com.example.myapplication.Views.PhomeView
import com.example.myapplication.Views.SmsView


@Composable
fun NavManager(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Routes.PhoneView.route) {
        composable(Routes.PhoneView.route) {
            PhomeView()
        }
        composable(Routes.EmailView.route) {
            EmailView()
        }
        composable(Routes.SmsView.route) {
            SmsView()
        }
    }
}