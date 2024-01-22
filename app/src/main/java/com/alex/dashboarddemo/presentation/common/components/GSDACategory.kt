package com.alex.dashboarddemo.presentation.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alex.dashboarddemo.presentation.common.model.GSDACategoriesModel

@Composable
fun GSDACategories(item: List<GSDACategoriesModel>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        itemsIndexed(item) { _, data ->
            Box(
                modifier = Modifier.clip(RoundedCornerShape(5.dp)),
            ) {
                GSDACategoryItem(
                    txtCategoryTitle = data.txtCategoryTitle,
                    imgUrl = data.imgUrl,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GSDACategoryItem(
    txtCategoryTitle: String,
    imgUrl: String,
    backgroundColor: Color = Color.White,
) {
    Column(
        modifier =
        Modifier
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GSDACategoryImage(
            imgUrl = imgUrl,
        )
        GSDACategoryInfo(
            title = txtCategoryTitle,
        )
    }
}

@Composable
fun GSDACategoryImage(imgUrl: String) {
    Box(
        modifier =
        Modifier
            .size(60.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center,
    ) {
        GSDALoadImage(
            image = imgUrl,
        )
    }
}

@Composable
fun GSDACategoryInfo(title: String?) {
    title?.let {
        GSDAPrimaryText {
            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                text = it,
                style = MaterialTheme.typography.subtitle2,
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFD1CECE)
@Composable
fun GSDACategoriesPreview() {
    val categories =
        listOf(
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/oferta.png",
                txtCategoryTitle = "Ofertas",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/lineaBlanca.png",
                txtCategoryTitle = "Linea Blanca",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ropa.png",
                txtCategoryTitle = "Ropa",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/calzado.png",
                txtCategoryTitle = "Calzado",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/electronica.png",
                txtCategoryTitle = "Electrónicos",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/videoJuegos.png",
                txtCategoryTitle = "Videojuegos",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/computo.png",
                txtCategoryTitle = "Cómputo",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/muebles.png",
                txtCategoryTitle = "Muebles",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/belleza.png",
                txtCategoryTitle = "Belleza",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/hogar.png",
                txtCategoryTitle = "Hogar",
            ),
            GSDACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/todas.png",
                txtCategoryTitle = "Todas",
            ),
        )
    GSDACategories(categories)
}
