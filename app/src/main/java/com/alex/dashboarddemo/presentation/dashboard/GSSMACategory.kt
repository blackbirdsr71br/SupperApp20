package com.alex.dashboarddemo.presentation.dashboard

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
import com.alex.dashboarddemo.presentation.components.LoadImage
import com.alex.dashboarddemo.presentation.components.PrimaryText

data class GSSMACategoriesModel(
    val imgUrl: String,
    val txtCategoryTitle: String
)

@Composable
fun GSSMACategories(item: List<GSSMACategoriesModel>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        itemsIndexed(item) { _, data ->
            Box(
                modifier = Modifier.clip(RoundedCornerShape(5.dp))
            ) {
                GSSMACategoryItem(
                    txtCategoryTitle = data.txtCategoryTitle,
                    imgUrl = data.imgUrl
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GSSMACategoryItem(
    txtCategoryTitle: String,
    imgUrl: String,
    backgroundColor: Color = Color.White
) {
    Column(
        modifier =
        Modifier
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CategoryImage(
            imgUrl = imgUrl
        )
        CategoryInfo(
            title = txtCategoryTitle
        )
    }
}

@Composable
fun CategoryImage(imgUrl: String) {
    Box(
        modifier =
        Modifier
            .size(60.dp)
            .background(Color.White, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        LoadImage(
            image = imgUrl
        )
    }
}

@Composable
fun CategoryInfo(title: String?) {
    title?.let {
        PrimaryText {
            Text(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp),
                text = it,
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFD1CECE)
@Composable
fun CategoriesPreview() {
    val categories =
        listOf(
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/oferta.png",
                txtCategoryTitle = "Ofertas"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/lineaBlanca.png",
                txtCategoryTitle = "Linea Blanca"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ropa.png",
                txtCategoryTitle = "Ropa"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/calzado.png",
                txtCategoryTitle = "Calzado"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/electronica.png",
                txtCategoryTitle = "Electrónicos"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/videoJuegos.png",
                txtCategoryTitle = "Videojuegos"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/computo.png",
                txtCategoryTitle = "Cómputo"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/muebles.png",
                txtCategoryTitle = "Muebles"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/belleza.png",
                txtCategoryTitle = "Belleza"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/hogar.png",
                txtCategoryTitle = "Hogar"
            ),
            GSSMACategoriesModel(
                imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/todas.png",
                txtCategoryTitle = "Todas"
            )
        )
    GSSMACategories(categories)
}
