package com.dot.share.screens.welcome

import com.dot.share.common.ui.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class WelcomeViewModel : BaseViewModel<WelcomeEvent>() {

    private val _uiState = MutableStateFlow(WelcomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: WelcomeAction) {

    }

}