package com.alex.dashboarddemo.presentation.common.components.gsdaProductImageCard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.presentation.common.components.GSDALoadImage
import com.alex.dashboarddemo.presentation.common.model.GSDAProductImageCardImageModel
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GSDAProductImageCardImage(
    gsvcProductImageCardImageModel: GSDAProductImageCardImageModel,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize(),
            shape = RoundedCornerShape(0.dp),
            elevation = 0.dp,
        ) {
            GSDALoadImage(
                image = gsvcProductImageCardImageModel.urlImage,
            )
        }
    }
}

@Composable
fun GSDAWhitPromoImage(
    urlImagePromo: String,
    imagePromoVisible: Boolean = false,
) {
    AnimatedVisibility(visible = imagePromoVisible) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.TopEnd,
        ) {
            GlideImage(
                modifier = Modifier
                    .size(25.dp),
                imageModel = urlImagePromo,
                circularReveal = CircularReveal(duration = 250),
                contentScale = ContentScale.Fit,
                previewPlaceholder = R.drawable.ic_hot_sale,
                placeHolder = painterResource(id = R.drawable.ic_hot_sale),
                error = painterResource(id = R.drawable.ic_hot_sale),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun GSDAImagePreview() {
    GSDAProductImageCardImageModel(
        urlImage = R.drawable.telefono,
    ).apply {
        GSDAProductImageCardImage(
            gsvcProductImageCardImageModel = this,
        )
    }
}
