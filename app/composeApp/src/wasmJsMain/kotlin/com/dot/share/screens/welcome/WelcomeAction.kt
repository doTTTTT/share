package com.dot.share.screens.welcome

sealed interface WelcomeAction {

    data object SearchingResource : WelcomeAction

    data object AvailableResource : WelcomeAction

    data object Login : WelcomeAction

    data object Back : WelcomeAction

}