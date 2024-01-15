package com.alex.dashboarddemo.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

typealias ComposableFun = @Composable () -> Unit

data class GSSMADirectoryGridModel(
    val txttitle : String,
    val gssmaDirectoryCardModel : List<GSSMADirectoryCardModel>,
)

@Composable
fun GSSMAVerticalGridView(
    composableFuns : MutableList<ComposableFun>,
) {
    val lazyGState = rememberLazyStaggeredGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .height((155 * (2)).dp)
                .fillMaxWidth()
                .background(Color.Transparent)
                .nestedScroll(nestedScroll),
            state = lazyGState,
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(0.dp),
            verticalItemSpacing = 12.dp,
        ) {
            items(composableFuns) { content ->
                content()
            }
        }
    }
}

@Composable
fun GSSMADirectoryGridView(gssmaDirectoryGridModel : List<GSSMADirectoryGridModel>) {
    val lazyGState = rememberLazyGridState()
    val nestedScroll = rememberNestedScrollInteropConnection()
    Column {
        for (aList in gssmaDirectoryGridModel) {
            // println("Elemento: ${aList.txt_title}")

            Text(
                modifier = Modifier.padding(
                    start = 10.dp,
                    bottom = if (aList.gssmaDirectoryCardModel.size == 1) 6.dp else 0.dp,
                ),
                text = aList.txttitle,
                fontSize = 18.sp,
            )

            LazyVerticalGrid(
                columns = object : GridCells {
                    override fun Density.calculateCrossAxisCellSizes(
                        availableSize : Int,
                        spacing : Int,
                    ) : List<Int> {
                        val firstColumn = (availableSize - spacing) / 2
                        val secondColumn = availableSize - spacing - firstColumn
                        return listOf(firstColumn, secondColumn)
                    }
                },
                state = lazyGState,
                modifier = Modifier
                    .nestedScroll(nestedScroll)
                    .height(
                        if (aList.gssmaDirectoryCardModel.size % 2 == 0) {
                            (95 * (aList.gssmaDirectoryCardModel.size / 2)).dp
                        } else {
                            if (aList.gssmaDirectoryCardModel.size == 1) {
                                (93 * (aList.gssmaDirectoryCardModel.size)).dp
                            } else {
                                (65 * (aList.gssmaDirectoryCardModel.size)).dp
                            }
                        },
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(8.dp),

                ) {
                aList.gssmaDirectoryCardModel.forEachIndexed { index, data ->
                    // println("Elemento: $data")
                    if (aList.gssmaDirectoryCardModel.size % 2 == 0) {
                        item(span = { GridItemSpan(1) }) {
                            Column {
                                GSSMADirectoryCard(data)
                            }
                        }
                    } else {
                        if (index % 3 == 0) {
                            item(span = { GridItemSpan(maxLineSpan) }) {
                                Column {
                                    GSSMADirectoryCard(data)
                                }
                            }
                        } else {
                            item(span = { GridItemSpan(1) }) {
                                Column {
                                    GSSMADirectoryCard(data)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun GridPreview() {
    val componente : ComposableFun = { }
    val composableFuns = mutableListOf(componente)
    val context = LocalContext.current

    composableFuns.add {
        GSSMAAccountsModel(
            doubleDin = true,
        ).apply {
            GSSMAAccounts(
                this,
            )
        }
    }
    composableFuns.add {
        GSSMAAccountsModel(
            doubleDin = false,
        ).apply {
            GSSMAAccounts(
                this,
            )
        }
    }

    composableFuns.add {
        GSSMAAccountsModel(
            doubleDin = false,
        ).apply {
            GSSMAAccounts(
                this,
            )
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GSSMAVerticalGridView(composableFuns)
    }
}

@Preview(showBackground = true)
@Composable
fun DirectoryGridPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFDD6D6D6),
    ) {
        val destacados = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/bancoazteca.png",
                color_Background = Color(0xFF154205),
                onCardClick = {},
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/elektra.png",
                color_Background = Color(0xFFFFEB3B),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/tvazteca.png",
                color_Background = Color(0xFF010616),
            ),
        )
        val calzado = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/flexi.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/kswiss.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/stylo.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )

        val colchones = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/atlas.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/restonic.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/america.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/springair.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )

        val electronica = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/sony.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/steren.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/samsung.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val lineablanca = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/avera.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/mabe.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/whirpool.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val motos = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/italika.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/hero.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val muebles = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/alterego.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/kessa.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val perfumes = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/cards/fragance.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val ropa = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/c&a.png",
                color_Background = Color(0xFFFDFDFC),
            ),
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/cards/theilusion.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )
        val servicios = listOf(
            GSSMADirectoryCardModel(
                img_imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/estrellablanca.png",
                color_Background = Color(0xFFFDFDFC),
            ),
        )

        val gridDirectory = listOf<GSSMADirectoryGridModel>(
            GSSMADirectoryGridModel(
                txttitle = "Destacado",
                gssmaDirectoryCardModel = destacados,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Calzado",
                gssmaDirectoryCardModel = calzado,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Colchones",
                gssmaDirectoryCardModel = colchones,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Electronica",
                gssmaDirectoryCardModel = electronica,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Linea blanca",
                gssmaDirectoryCardModel = lineablanca,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Motos",
                gssmaDirectoryCardModel = motos,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Muebles",
                gssmaDirectoryCardModel = muebles,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Perfumes",
                gssmaDirectoryCardModel = perfumes,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Ropa",
                gssmaDirectoryCardModel = ropa,
            ),
            GSSMADirectoryGridModel(
                txttitle = "Servicios",
                gssmaDirectoryCardModel = servicios,
            ),
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
            ) {
                GSSMADirectoryGridView(gridDirectory)
            }
        }
    }
}
