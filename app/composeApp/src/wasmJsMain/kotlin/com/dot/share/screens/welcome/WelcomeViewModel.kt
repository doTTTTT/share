package com.dot.share.screens.welcome

import com.dot.share.common.ui.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class WelcomeViewModel : BaseViewModel<WelcomeEvent>() {

    private val _uiState = MutableStateFlow(WelcomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: WelcomeAction) {
        when (action) {
            WelcomeAction.AvailableResource -> onAvailableResource()
            WelcomeAction.Login -> onLogin()
            WelcomeAction.SearchingResource -> onSearchingResource()
            WelcomeAction.Back -> onBack()
        }
    }

    private fun onAvailableResource() {
        _uiState.update { it.copy(content = it.content + WelcomeContent.AvailableResource) }
    }

    private fun onLogin() {
        // TODO Login page
    }

    private fun onSearchingResource() {
        _uiState.update { it.copy(content = it.content + WelcomeContent.SearchingResource) }
    }

    private fun onBack() {
        _uiState.update { state ->
            if (state.content.size > 1) {
                state.copy(content = state.content.dropLast(1))
            } else {
                state
            }
        }
    }

}