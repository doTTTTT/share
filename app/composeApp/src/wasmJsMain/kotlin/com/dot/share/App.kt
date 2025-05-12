package com.dot.share

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dot.share.di.viewModelModule
import com.dot.share.routes.Routes
import com.dot.share.screens.welcome.WelcomeScreen
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                viewModelModule
            )
        }
    ) {
        MaterialTheme {
            Content()
        }
    }
}

@Composable
private fun Content() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Welcome,
        modifier = Modifier.fillMaxSize()
    ) {
        composable<Routes.Welcome> { WelcomeScreen() }
    }
}
