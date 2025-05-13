@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalBrowserHistoryApi::class)

package com.dot.share

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.backhandler.BackGestureDispatcher
import androidx.compose.ui.backhandler.LocalBackGestureDispatcher
import androidx.compose.ui.layout.LookaheadScope
import androidx.navigation.ExperimentalBrowserHistoryApi
import androidx.navigation.bindToNavigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dot.share.di.viewModelModule
import com.dot.share.routes.Routes
import com.dot.share.screens.welcome.WelcomeScreen
import kotlinx.browser.window
import org.koin.compose.KoinApplication

@Composable
fun App() {
    val dispatcher = remember {
        object : BackGestureDispatcher() {}
    }

    KoinApplication(
        application = {
            modules(
                viewModelModule
            )
        }
    ) {
        MaterialTheme {
            CompositionLocalProvider(
                LocalBackGestureDispatcher provides dispatcher
            ) {
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
        composable<Routes.Welcome> { WelcomeScreen() }
    }
}
