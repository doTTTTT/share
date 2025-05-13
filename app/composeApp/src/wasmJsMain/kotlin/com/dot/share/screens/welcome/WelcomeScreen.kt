@file:OptIn(ExperimentalComposeUiApi::class)

package com.dot.share.screens.welcome

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dot.share.common.ui.LaunchedEffectFlowWithLifecycle
import com.dot.share.routes.Routes
import com.dot.share.screens.welcome.content.SearchingResource
import com.dot.share.screens.welcome.content.Selection
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun WelcomeScreen(
    onNavigate: (Routes) -> Unit,
    viewModel: WelcomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffectFlowWithLifecycle(viewModel.event) { event ->
        when (event) {
            is WelcomeEvent.Navigate -> onNavigate(event.route)
        }
    }

    Content(
        uiState = uiState,
        onAction = viewModel::onAction
    )
}

@Composable
private fun Content(
    uiState: WelcomeUiState,
    onAction: (WelcomeAction) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        LoginButton(onAction = onAction)
        Spacer(Modifier.weight(1f))
        AnimatedVisibility(
            visible = uiState.content.size > 1
        ) {
            IconButton(
                onClick = { onAction(WelcomeAction.Back) },
                modifier = Modifier.align(Alignment.Start)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = null
                )
            }
        }
        WelcomeContent(uiState = uiState, onAction = onAction)
        Spacer(Modifier.weight(1f))
        Text(
            text = "Copyright by GrosMalin Inc.",
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
private fun WelcomeContent(
    uiState: WelcomeUiState,
    onAction: (WelcomeAction) -> Unit
) {
    AnimatedContent(
        targetState = uiState.content.last(),
        contentAlignment = Alignment.Center,
        transitionSpec = {
            (fadeIn() + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start))
                .togetherWith(fadeOut() + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start))
        }
    ) { target ->
        when (target) {
            WelcomeContent.Selection -> Selection(onAction = onAction)
            WelcomeContent.AvailableResource -> SearchingResource()
            WelcomeContent.SearchingResource -> Unit
        }
    }
}

@Composable
private fun ColumnScope.LoginButton(
    onAction: (WelcomeAction) -> Unit
) {
    OutlinedButton(
        onClick = { onAction(WelcomeAction.Login) },
        modifier = Modifier.align(Alignment.End)
    ) {
        Text(
            text = "Login"
        )
    }
}