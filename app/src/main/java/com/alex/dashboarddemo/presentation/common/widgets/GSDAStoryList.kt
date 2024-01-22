package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.common.components.GSDAStoryItem
import com.alex.dashboarddemo.presentation.common.model.GSDATweet

@Composable
fun GSDAStoryList(
    profiles: List<GSDATweet>,
    onProfileClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.padding(top = 8.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        items(profiles) {
            GSDAStoryItem(
                profileImageId = it.authorImageId,
                profileName = it.author,
                isMe = it.id == 1,
                onClick = onProfileClicked,
            )
        }
    }
}
