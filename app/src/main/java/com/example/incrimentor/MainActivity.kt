package com.example.incrimentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.incrimentor.ui.theme.IncrimentorTheme

class MainActivity : ComponentActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IncrimentorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

                    Layout(mainViewModel)
                }
            }
        }
    }
}

@Composable
fun Layout(test:MainViewModel) {
    var result = remember {
        mutableStateOf(test.count)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = result.value.toString(), fontSize = 64.sp)
        Spacer(modifier = Modifier.height(6.dp))
        Row (
            modifier  = Modifier.align(alignment = Alignment.CenterHorizontally)
                ){
            Button(onClick = {
                test.increment()
                result.value = test.count
            },
                shape = RectangleShape,
            ) {
                Text(text = "Increment me!")
            }
            Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            Button(onClick = {
                test.decrement()
                result.value = test.count
            },
                shape = RectangleShape,
            ) {
                Text(text = "Decrement me!")
            }
        }
    }
}





