package com.dot.share.screens.welcome

import androidx.compose.runtime.Immutable

@Immutable
internal data class WelcomeUiState(
    val test: String = "",
    val content: List<WelcomeContent> = listOf(WelcomeContent.Selection)
)

internal sealed interface WelcomeContent {

    data object Selection : WelcomeContent

    data object SearchingResource : WelcomeContent

    data object AvailableResource : WelcomeContent

}