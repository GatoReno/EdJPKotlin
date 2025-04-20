package com.example.myapplication.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainViewModel : ViewModel() {
    var result by mutableStateOf("")


    fun fetchData() {
        viewModelScope.launch {
            CallApi()
        }
    }

    suspend fun CallApi() {
        val result = withContext(Dispatchers.IO) {
            delay(3000)
            result = "Api info"
        }
    }
}