package com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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


data class GSSMACategoriesStoreModel(
    val imgImgurl: String,
    val txtCategorytitle: String,
    val onCardClicked: () -> Unit,
)

@Composable
fun GSSMACategoriesPreview(item: List<GSSMACategoriesStoreModel>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        itemsIndexed(item) { _, data ->
            Box(
                modifier = Modifier.clip(RoundedCornerShape(5.dp)),
            ) {
                GSSMAStoreCategoriesCard(
                    txtCategoryTitle = data.txtCategorytitle,
                    imgUrl = data.imgImgurl,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GSSMAStoreCategoriesCard(
    modifier: Modifier = Modifier,
    txtCategoryTitle: String,
    imgUrl: String,
) {
    Card(
        modifier = modifier
            .height(70.dp),
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
                softWrap = true,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.width(12.dp))
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
fun CardPreviewStore() {
    GSSMAStoreCategoriesCard(
        txtCategoryTitle = "Zapatos \nde hombre",
        imgUrl = "",
    )
}

@Preview
@Composable
fun CardListPreview() {
    val categories = listOf(
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ofertas.png",
            txtCategorytitle = "Mujer",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/lineaBlanca.png",
            txtCategorytitle = "Zapatos de Hombre",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ropa.png",
            txtCategorytitle = "Zapatos \nde Mujer",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/calzado.png",
            txtCategorytitle = "Zapatos \nde niño",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/electronica.png",
            txtCategorytitle = "Zapatos \nde niña",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/videoJuegos.png",
            txtCategorytitle = "Videojuegos",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/computo.png",
            txtCategorytitle = "Cómputo",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/muebles.png",
            txtCategorytitle = "Muebles",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/belleza.png",
            txtCategorytitle = "Belleza",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/hogar.png",
            txtCategorytitle = "Hogar",
            onCardClicked = {},
        ),
        GSSMACategoriesStoreModel(
            imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/todas.png",
            txtCategorytitle = "Todas",
            onCardClicked = {},
        ),

    )
    GSSMACategoriesPreview(
        item = categories,
    )
}
