package com.dot.share

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.AccountTree
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass

@Composable
fun App() {
    MaterialTheme {
        Content()
    }
}

@Composable
private fun Content() {
    val windowSize = currentWindowAdaptiveInfo()
    val modifier = Modifier

    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 32.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Vous êtes une entreprise qui ?",
            style = MaterialTheme.typography.headlineLarge
        )
        when (windowSize.windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> Column(
                modifier = modifier
                    .width(IntrinsicSize.Max),
                content = { Cards() }
            )

            else -> Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = modifier
                    .height(IntrinsicSize.Max),
                content = { Cards() }
            )
        }
    }
}

@Composable
private fun Cards() {
    CardItem(
        icon = Icons.Outlined.AccountTree,
        title = "A besoin de ressources temporaires",
        description = "Vous cherchez des ressources temporaires ?"
    )
    CardItem(
        icon = Icons.Outlined.AccountBalance,
        title = "Des ressources en trop",
        description = "Vous avez des ressources en trop ?"
    )
}

@Composable
private fun CardItem(
    icon: ImageVector,
    title: String,
    description: String
) {
    ElevatedCard(
        onClick = {}
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .width(300.dp)
                .padding(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = description,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}