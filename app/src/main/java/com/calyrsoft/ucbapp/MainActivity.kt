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
        // waiting for view to draw to better represent a captured error with a screenshot
        findViewById<android.view.View>(android.R.id.content).viewTreeObserver.addOnGlobalLayoutListener {
            // Bloque de prueba agregado automáticamente por el wizard de Sentry
      /*try {
        throw Exception("This app uses Sentry! :)")
      } catch (e: Exception) {
        Sentry.captureException(e)
      }*/
        }

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