package com.alex.dashboarddemo.presentation.common.components.collapsingtoolbarincompose.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.data.mockdata.categories
import com.alex.dashboarddemo.presentation.common.model.GSDACategoriesStoreModel

@Composable
fun GSDACategoriesList(item: List<GSDACategoriesStoreModel>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        itemsIndexed(item) { index, data ->
            Box(
                modifier = Modifier.clip(RoundedCornerShape(5.dp)),
            ) {
                GSDAStoreCategoriesCard(
                    txtCategoryTitle = data.txtCategoryTitle,
                    imgUrl = data.imgImgUrl,
                    onCardClicked = data.onCardClicked,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GSDAStoreCategoriesCard(
    modifier: Modifier = Modifier,
    txtCategoryTitle: String,
    imgUrl: String,
    onCardClicked: () -> Unit,
) {
    Card(
        modifier = modifier
            .height(70.dp)
            .clickable { onCardClicked.invoke() },
        shape = RoundedCornerShape(10.dp),
    ) {
        Row(
            modifier = modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = txtCategoryTitle,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                overflow = TextOverflow.Clip,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier
                    .size(52.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.billie),
                contentDescription = "Store Categories Card",
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun GSDACardPreview() {
    GSDAStoreCategoriesCard(
        txtCategoryTitle = "Zapatos \nde hombre",
        imgUrl = "",
        onCardClicked = {},
    )
}

@Preview
@Composable
fun GSDACardListPreview() {
    GSDACategoriesList(item = categories)
}
