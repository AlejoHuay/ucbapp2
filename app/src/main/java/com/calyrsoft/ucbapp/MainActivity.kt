package com.calyrsoft.ucbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.calyrsoft.ucbapp.presentation.GithubScreen
import com.calyrsoft.ucbapp.ui.theme.UcbappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UcbappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GithubScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}