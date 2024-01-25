package com.alex.dashboarddemo.data.cache.preview

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.domain.model.GSDAGenericCard
import com.alex.dashboarddemo.presentation.common.model.GSDACategoriesStoreModel
import com.alex.dashboarddemo.presentation.common.model.GSDADirectoryCardModel
import com.alex.dashboarddemo.presentation.common.model.GSDADirectoryGridModel
import com.alex.dashboarddemo.presentation.common.model.GSDAFlatCard
import com.alex.dashboarddemo.presentation.common.model.GSDAFlatCardType
import com.alex.dashboarddemo.presentation.common.model.GSDAGenericProductCardBuilder
import com.alex.dashboarddemo.presentation.common.model.GSDAImageType
import com.alex.dashboarddemo.presentation.common.model.GSDAKidsData
import com.alex.dashboarddemo.presentation.common.model.GSDAStandAloneGridModel
import com.alex.dashboarddemo.ui.theme.GSVCTitleBase100Left
import com.alex.dashboarddemo.ui.theme.SDAColor

object GSDAPreviewDataProvider {
    val gridList1 = listOf(
        GSDAFlatCard(
            featureMessage = "Nuevo",
            image = R.drawable.baseline_bedtime_24,
            message = "Soy la primer tarjeta",
            route = "Tarjeta 1"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 2",
            route = "Tarjeta 2"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Recarga tiempo aire",
            route = "Tarjeta 3"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 4",
            route = "Tarjeta 4"
        ),
        GSDAFlatCard(
            bgCardColor = Color.Black,
            style = GSVCTitleBase100Left,
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 5",
            route = "Tarjeta 5"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 6",
            route = "Tarjeta 6"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 7",
            route = "Tarjeta 7"
        ),
        GSDAFlatCard(
            style = GSVCTitleBase100Left,
            bgCardColor = Color.Black,
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 8",
            route = "Tarjeta 8"
        ),
        GSDAFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Soy la ultima tarjeta",
            size = GSDAFlatCardType.COMPOSABLE,
            content = {
            },
            route = "Tarjeta 9"
        )
    )
    val configData = GSDAGenericCard(
        image = "ic_bitcoin",
        backgroundColor = Color(0xFF0C0623),
        title = "Wallet Bitcoin",
        text = "Compra y vende con la red de pago Lightning",
        textButton = "Conocer más"
    )
    val products = mutableListOf(
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.DrawableImage(image = R.drawable.estufa)
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.DrawableImage(image = R.drawable.horno)
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.DrawableImage(image = R.drawable.telefono)
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        }
    )
    private val relevantes = listOf(
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        }
    )
    private val masrecientes = listOf(
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        }
    )
    private val descuento = listOf(
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        },
        GSDAGenericProductCardBuilder.build {
            image = GSDAImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                contentScale = null
            )
            imageList = listOf(
                GSDAImageType.UrlImage(
                    image = "data:image/jpeg;base64,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",
                    background = Color.Red
                )
            )
            label = "Steren"
            description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
            prices = Pair(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.W500,
                            textDecoration = TextDecoration.LineThrough,
                            color = SDAColor.GSVCInteractionDisable
                        )
                    ) {
                        append("$1,169")
                    }
                },
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                        append("$1,074")
                    }
                }
            )
            body = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold))
                    )
                ) {
                    append("$54")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 8.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        baselineShift = BaselineShift.Superscript
                    )
                ) {
                    append("80")
                }
                withStyle(
                    style = SpanStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                        color = SDAColor.GSVCInteractions
                    )
                ) {
                    append("\nPago semanal")
                }
            }
        }
    )
    val standAloneStore = listOf(
        GSDAStandAloneGridModel(
            txtTitle = "Relevantes",
            productCards = relevantes
        ),
        GSDAStandAloneGridModel(
            txtTitle = "Más reciente",
            productCards = masrecientes
        ),
        GSDAStandAloneGridModel(
            txtTitle = "Descuento",
            productCards = descuento
        )
    )
    val categories = listOf(
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ofertas.png",
            txtCategoryTitle = "Mujer",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/lineaBlanca.png",
            txtCategoryTitle = "Zapatos \nde Hombre",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ropa.png",
            txtCategoryTitle = "Zapatos \nde Mujer",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/calzado.png",
            txtCategoryTitle = "Zapatos \nde niño",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/electronica.png",
            txtCategoryTitle = "Zapatos \nde niña",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/videoJuegos.png",
            txtCategoryTitle = "Videojuegos",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/computo.png",
            txtCategoryTitle = "Cómputo",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/muebles.png",
            txtCategoryTitle = "Muebles",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/belleza.png",
            txtCategoryTitle = "Belleza",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/hogar.png",
            txtCategoryTitle = "Hogar",
            onCardClicked = {}
        ),
        GSDACategoriesStoreModel(
            imgImgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/todas.png",
            txtCategoryTitle = "Todas",
            onCardClicked = {}
        )

    )
    val kidsList = listOf(
        GSDAKidsData(
            "Sitting Pretty",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.carrousell1
        ),
        GSDAKidsData(
            "Love her Expression",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.carrousell2
        )
        /*GSDAKidsData(
            "Childhood Superman",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.image_3,
        ),
        GSDAKidsData(
            "Candle Night At Marina",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.image_4,
        ),
        GSDAKidsData(
            "Girl with Beautiful smile",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.image_5,
        ),
        GSDAKidsData(
            "Bath Time",
            4.0f,
            "All the Children in the word are cute and innocent for like this...",
            R.drawable.image_6,
        ),*/
    )
    private val featured = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/bancoazteca.png",
            colorBackground = Color(0xFF154205),
            onCardClick = {}
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/elektra.png",
            colorBackground = Color(0xFFFFEB3B)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/tvazteca.png",
            colorBackground = Color(0xFF010616)
        )
    )
    private val footwear = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/flexi.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/kswiss.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/stylo.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val mattresses = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/atlas.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/restonic.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/america.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/springair.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val electronics = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/sony.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/steren.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/samsung.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val whiteLine = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/avera.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/mabe.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/whirpool.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val motorcycles = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/italika.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/hero.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val furniture = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/alterego.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/kessa.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val perfumes = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/cards/fragance.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val clothes = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/medio/c&a.png",
            colorBackground = Color(0xFFFDFDFC)
        ),
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/cards/theilusion.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    private val services = listOf(
        GSDADirectoryCardModel(
            imgUrl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Tiendas/directorio/mosaico/largo/estrellablanca.png",
            colorBackground = Color(0xFFFDFDFC)
        )
    )
    val gridDirectory = listOf(
        GSDADirectoryGridModel(
            txtTitle = "Destacado",
            directoryCards = featured
        ),
        GSDADirectoryGridModel(
            txtTitle = "Calzado",
            directoryCards = footwear
        ),
        GSDADirectoryGridModel(
            txtTitle = "Colchones",
            directoryCards = mattresses
        ),
        GSDADirectoryGridModel(
            txtTitle = "Electronica",
            directoryCards = electronics
        ),
        GSDADirectoryGridModel(
            txtTitle = "Linea blanca",
            directoryCards = whiteLine
        ),
        GSDADirectoryGridModel(
            txtTitle = "Motos",
            directoryCards = motorcycles
        ),
        GSDADirectoryGridModel(
            txtTitle = "Muebles",
            directoryCards = furniture
        ),
        GSDADirectoryGridModel(
            txtTitle = "Perfumes",
            directoryCards = perfumes
        ),
        GSDADirectoryGridModel(
            txtTitle = "Ropa",
            directoryCards = clothes
        ),
        GSDADirectoryGridModel(
            txtTitle = "Servicios",
            directoryCards = services
        )
    )
}
