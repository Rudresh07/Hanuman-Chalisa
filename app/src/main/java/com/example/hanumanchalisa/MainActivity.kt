package com.example.hanumanchalisa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.hanumanchalisa.Screen.HomeScreen
import com.example.hanumanchalisa.ui.theme.HanumanChalisaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HanumanChalisaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   HomeScreen(innerPadding)
                }
            }
        }
    }
}



