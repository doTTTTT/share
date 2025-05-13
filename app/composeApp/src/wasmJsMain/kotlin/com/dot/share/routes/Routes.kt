package com.dot.share.routes

import kotlinx.serialization.Serializable

sealed interface Routes {

    @Serializable
    data object Welcome : Routes

    @Serializable
    data object Login : Routes

}