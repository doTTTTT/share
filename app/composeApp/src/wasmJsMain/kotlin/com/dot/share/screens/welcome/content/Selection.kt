package com.dot.share.screens.welcome.content

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
import com.dot.share.screens.welcome.WelcomeAction

@Composable
internal fun Selection(
    onAction: (WelcomeAction) -> Unit
) {
    val windowSize = currentWindowAdaptiveInfo()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Vous êtes une entreprise qui ?",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        when (windowSize.windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .width(IntrinsicSize.Max),
                content = { Cards(onAction = onAction) }
            )

            else -> Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .height(IntrinsicSize.Max),
                content = { Cards(onAction = onAction) }
            )
        }
    }
}

@Composable
private fun Cards(
    onAction: (WelcomeAction) -> Unit
) {
    CardItem(
        icon = Icons.Outlined.AccountTree,
        title = "A besoin de ressources temporaires",
        description = "Vous cherchez des ressources temporaires ?",
        onClick = { onAction(WelcomeAction.SearchingResource) }
    )
    CardItem(
        icon = Icons.Outlined.AccountBalance,
        title = "Des ressources en trop",
        description = "Vous avez des ressources en trop ?",
        onClick = { onAction(WelcomeAction.AvailableResource) }
    )
}

@Composable
private fun CardItem(
    icon: ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick
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