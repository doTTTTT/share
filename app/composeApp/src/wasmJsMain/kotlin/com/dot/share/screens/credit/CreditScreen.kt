package com.dot.share.screens.credit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.share.resources.Res
import com.share.resources.credit
import org.jetbrains.compose.resources.painterResource

@Composable
fun CreditScreen() {
    Image(
        painter = painterResource(Res.drawable.credit),
        contentDescription = null,
        modifier = Modifier.fillMaxSize()
    )
}