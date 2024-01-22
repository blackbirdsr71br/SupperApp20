package com.alex.dashboarddemo.presentation.common.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.components.GSDAPrimaryText
import com.alex.dashboarddemo.presentation.common.components.GSDASecondaryText

@Composable
fun GSDAShowHeader(
    title: String,
    subtitle: String,
    hasMore: Boolean,
) {
    Column(
        modifier = Modifier.padding(
            horizontal = dimensionResource(id = R.dimen.padding),
        ),
    ) {
        Row(
            modifier = Modifier.padding(
                vertical = 2.dp,
            ),
        ) {
            GSDAPrimaryText {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    text = title,
                    style = MaterialTheme.typography.h6,
                )
            }
            if (hasMore) {
                TextButton(
                    onClick = {
                    },
                ) {
                    Text(
                        modifier = Modifier,
                        text = "View All",
                        style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.W600),
                    )
                }
            }
        }
        GSDASecondaryText {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}
