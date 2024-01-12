package com.alex.dashboarddemo.ui.dashboard


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.placeholder
import androidx.wear.compose.material.placeholderShimmer
import androidx.wear.compose.material.rememberPlaceholderState
import kotlinx.coroutines.delay


@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun PlaceHolder() {


    var labelText by remember { mutableStateOf("") }
    val chipPlaceholderState = rememberPlaceholderState {
        labelText.isNotEmpty()
    }
    Column {


        Text(
            text = labelText,
            fontSize = 25.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(90.dp)
                .placeholderShimmer(chipPlaceholderState)
                .placeholder(chipPlaceholderState)
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .placeholderShimmer(
                    chipPlaceholderState,
                    shape = RoundedCornerShape(0.dp)
                        )
                .placeholder(chipPlaceholderState)
        ) {

        }
    }

// Simulate content loading
    LaunchedEffect(Unit) {
        delay(3000)
        labelText = "A label"
    }
    if (!chipPlaceholderState.isShowContent) {
        LaunchedEffect(chipPlaceholderState) {
            chipPlaceholderState.startPlaceholderAnimation()
        }
    }
}

@Preview
@Composable
fun PreviewShimmer() {
    PlaceHolder()
}
