@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)

package com.dot.share

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dot.share.di.viewModelModule
import com.dot.share.routes.Routes
import com.dot.share.screens.credit.CreditScreen
import com.dot.share.screens.login.LoginScreen
import com.dot.share.screens.welcome.WelcomeScreen
import kotlinx.browser.window
import org.koin.compose.KoinApplication

@Composable
fun App() {
    // Seems like back gesture doesn't work on web yet
//    val dispatcher = remember {
//        object : BackGestureDispatcher() {}
//

    KoinApplication(
        application = {
            modules(
                viewModelModule
            )
        }
    ) {
        MaterialTheme {
            CompositionLocalProvider {
                Content()
            }
        }
    }
}

@Composable
private fun Content() {
    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        window.bindToNavigation(navController)
    }

    NavHost(
        navController = navController,
        startDestination = Routes.Welcome,
        modifier = Modifier.fillMaxSize()
    ) {
        composable<Routes.Welcome> { WelcomeScreen(onNavigate = { navController.navigate(it) }) }
        composable<Routes.Login> { LoginScreen() }
        composable<Routes.Credit> { CreditScreen() }
    }
}
