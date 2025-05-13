package com.dot.share.screens.welcome.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun SearchingResource() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text= "When ?",
            style = MaterialTheme.typography.headlineLarge
        )
    }
}