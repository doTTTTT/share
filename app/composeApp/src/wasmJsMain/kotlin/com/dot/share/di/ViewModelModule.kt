package com.dot.share.di

import com.dot.share.screens.welcome.WelcomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

internal val viewModelModule = module {
    viewModelOf(::WelcomeViewModel)
}