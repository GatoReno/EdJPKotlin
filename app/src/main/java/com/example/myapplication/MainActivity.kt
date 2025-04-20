package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ViewModels.MainViewModel
import com.example.myapplication.Views.HomeView
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel : MainViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {

               HomeView()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Content(viewModel: MainViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "${viewModel.result}")
        Button(onClick = {viewModel.fetchData()})
        {
            Text(text = "Call Api")
        }
        ButtonColor()
    }
}

@Composable
fun ButtonColor(){
    var color by remember { mutableStateOf(false) }
    Button(onClick = {color = !color}, colors = ButtonDefaults.buttonColors(
        containerColor = if(color) Color.Blue else Color.Red
    )){
        Text(text = "Cambiar color")
    }

}
