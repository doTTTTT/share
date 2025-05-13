package com.dot.share.screens.welcome

import com.dot.share.common.ui.ViewModelEvent
import com.dot.share.routes.Routes

internal sealed interface WelcomeEvent : ViewModelEvent {

    data class Navigate(val route: Routes) : WelcomeEvent

}