package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.padding(top = 30.dp, bottom = 30.dp),
                    color = MaterialTheme.colorScheme.background) {
                   ExpandableCard()
                }

            }
        }
    }
}
@Composable
fun ObservableBtn() {
    var myVal = remember { mutableStateOf(false) }
    Log.d("recomp", "mycomposible")
    Button(onClick = { myVal.value = !myVal.value }) {
        Text(text = if (myVal.value) "True" else "False")
        Log.d("recomp", "button content by lambda")

    }
}
@Preview(showBackground = true)
@Composable
fun BoxGreeting() {
    Greeting()
}


@Composable
fun Greeting( ) {

    Column(Modifier.padding(top = 30.dp)) {
        SelectionContainer {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        }
        //MyText(name = "ED")
        //ObservableBtn()
    }

}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Surface(modifier = Modifier.weight(2f),color = Color.LightGray) {
//                Greeting("Android")
//            }
//            Surface(modifier = Modifier.weight(2f),color = Color.Gray) {
//                Greeting("Android2")
//            }
//
//
//        }
//    }
//}
//
//@Composable
//fun MyText(name: String) {
//    Text(
//        text = "Hello$name!", style = Typography.labelLarge
//    )
//}
//


