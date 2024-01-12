package com.alex.dashboarddemo.ui.dashboard

import android.content.Context
import android.widget.Toast
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
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.GSSMACategoriesStoreModel
import com.alex.dashboarddemo.ui.dashboard.collapsingtoolbarincompose.ui.composables.standAloneStore.GSSMAStandAloneGridModel
import com.alex.dashboarddemo.ui.dashboard.gsvcProductCard.GSVCGenericProductCardBuilder
import com.alex.dashboarddemo.ui.dashboard.gsvcProductCard.GSVCImageType
import com.alex.dashboarddemo.ui.theme.SDAColor


val products = mutableListOf(
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.estufa)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.horno)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.telefono)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
)

val flexi = mutableListOf(
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        description = "Mocasin flexi dama 32606 negro"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        description = "Choclo flexi Dama 35301 Café"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.estufa)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.horno)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.DrawableImage(image = R.drawable.telefono)
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
)


val relevantes = listOf(
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
)


val masrecientes = listOf(
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
)

val descuento = listOf(
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBw0QDQ0NDQ8NDQ4NDg4NDQ0PDQ8NDg0OFREWFxURExMYHSggGBolHRMVLTIhJzU3Li4yFx8/PTM4QykvLjcBCgoKDg0OGxAQGDAfHSU3NysrKy0sLTctKystMCsrLS0rOC03LSstLS0rLSsrLSs3Kys4LSswLS03Ky0tLS03N//AABEIAMkA+wMBIgACEQEDEQH/xAAcAAEAAgMBAQEAAAAAAAAAAAAAAggBAwYEBQf/xABCEAEAAQICBAkICAMJAAAAAAAAAQIDBBEFBhIhBxMxNFF0gbO0IjVBUnGRkpQUFlRVYcHR0iMlMhVCRHKCoaKjsf/EABkBAQADAQEAAAAAAAAAAAAAAAACAwQBBf/EACMRAQABBAEEAgMAAAAAAAAAAAABAgMxMhEEExRhEkEhUVL/2gAMAwEAAhEDEQA/AP3EAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH4dwm6x4i9pCMNN2ujB2qaqow9FU0U38q5oiq7lvridmZy5MtndnnKdFE1zwjVV8Yfts37cbproj/VDH0i369HxQrXc0zhLU0268No2iqYiYpnBYeasp5Jnyd2cdL104+xP+D0f8jhv2rvHj+lfd9LE/SLfr0fFB9It+vR8UK9xjMP9j0f8jhv2s/S8P8AY8B8jhv2u+N7O76WD+kW/Xo+KD6Rb9ej4oV8nGYf7Ho/5HDfta6sbY+x6P8AkcN+08b2d70sP9It+vR8UNlNUTGcTEx0xOauFWkLPowejvkMN+15K9L3LFdOJweWBu26oqmcLTTYouU576a7dPk1bumHPG9nej9LNj5urukasThbV2uIi5lNN2Kd1O3H96mPRFUZTEdFUPpM8xwuAHAAAAAAAAAAAAAAAAAAAVy16y/tS3HonC4TP8c6Yz/9WNVw1+qy0panowuFn/hDR020qb2IcFjMXa28bF2ia7td69sV+T5MzVyznv3ZTydLpMDVPFWs5mZm1ZmZnlmZtUzP+8y5+7hsNVcxkXblVF2K71VmmKa65vVTMcVRRERlvmZmZmeSN3K+7h6Zpoooq3VUUWqKo5cqqbdNMx2TEu2NpLmIe2Kktp5oqZ2mpQ37aFVTXNSE1AnVLxaRq/h1ex6ZqePHz5EuiyepHNZ/zWPCWHQue1I5rPtseEsOhebXtLXRrAAikAAAAAAAAAAAAAAAAAAK2cIc/wAyo6phu7hZNWrhEn+ZUdUw3dw09NtKm9iHnwOhLd3CYjG8fZouYaqY4iqNmuuiKYmKqas98zNWUU/hL58S0wlm0xHHKmZb4qZmuOmDBxRN21TcnZt1XLcXKo5abc1RtT2Rm8NOeW/dPpjon0pOPdNSEyxRFPE0TnO3N29FUeiLcU2pontmq78KEyCc1PJjZ8lvmXmxc+SCzOpHNZ9tjwlh0LndR+aT7bHhLDonm17S10awAIpAAAAAAAAAAAAAAAAAACtPCJ5yo6rhu7hZZWbhA84W+p4Xu4aemzKm9iHxISzQiWc2tnTiWJop6Pyfe+rF3Z2uMjLiLV6M7ddOc1xXVNEZ+mKbdU7+jkTxOqt2iKv4sVbNq/eyi1Xvi3s5RnyRtRXE/lKHzpT+MufjKN0bmJl0N/VS7TF+eNoniKLlcxNFVO1TTxsdmfEx8f4Plaa0dVhb9ViqrbmIira2dnOJz9Gc9EuxVE4cmmYy8UvPiv6W6ZaMTyJOLM6i80n22PCWHRuc1E5pPtseEsOjedXtLXRrAAgkAAAAAAAAAAAAAAAAAAKzcIcZaRojowmFj/rhZlWfhF85U9Vw3dw0dNmVN7EOfiUs2uGc2tQ3cbVu8qrdERHlTuiM8oj8N8++TjavWq3xMTvnfE8sezdHuaolnMGyq5VPLNU5xlOczOcZZZe5GqqZnOZmZ6ZnOUM2MwSmWnETubM2m/yAs5qJzOfbY8JYdG5zUPmfbY8JYdG8+vaWujWABBIAAAAAAAAAAAAAAAAAAVm4RvOVPVcN3cLMqy8I/nGnquG7uGjp8ypvYhz0SZoRLObWoTiTNDNnMEs2M2M2MwSzar3Inm13Z3OOrPaicz7bHhLDo3Oah8z7bHhLDo3n17S1UawAIpAAAAAAAAAAAAAAAAAACsvCR5xp6rhu7hZpWXhI84x1XDd3DR0+ZU3sQ5qBGJZaVKUCObOYMsGbGYMtdzkTzQuAtBqHzPtseEsOjc5qHzPtseEsOjYK9paqNYAEUgAAAAAAAAAAAAAAAAABWThJ8409Vw3dws2rJwlecaeq4bu4X2Myqu/TmBgaVKUAAAxICNbKNQLRah8z7bHhLDo3Oah8z7bHhLDo2GvaWmjWABFIAAAAAAAAAAAAAAAAAAVk4SvONPVcN3cLNqx8JnnGnquG7ulfYzKq79OXhliGYaFTLLDIDDMsAjKNScoT+YLR6h8z7bHhLDo3Oaicz7bHhLDo2KvaWijWABFIAAAAAAAAAAAAAAAAAAVj4TPOFPVsP3dKziuHDHoy7htIxVcoqi1cpmLN3KeLro2pmmmJ6aYmImOXyc+SYXWZ/MqrsfiHEwlCFMx0x704mn1o97SqZZI2fWp97Pk+tT73BhhKdn1qfejM0+tHvBGUPTHtTmY6Y96Nmia7tu1biquu5XTTTRRTNddUzPJTTG+Z/CHRaLUPmfbY8JYdI+PqpgK7GCtUXY2btUbdynOJ2N0RTRMxuzimmmJy3ZxL7DFVPNUtFMcRAAikAAAAAAAAAAAAAAAAAANOLwtq9RNq/bt3rdX9Vu5RTcoq9tM7pbgHPTqNoTl/szR/ylqPyJ1G0J92aP8AlLUfk6Ed5kc79RdCfdmj/lbX6JRqNoT7s0f8pZ/R0AcyOd+ouhPuzR/ytr9D6i6E+7NH/K2v0dEHMjnfqLoT7s0f8ra/R79F6v6PwszVhMHhMNVMZTXZw9u3XMdE1RGb6YcgA4AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP//Z",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
    GSVCGenericProductCardBuilder.build {
        image = GSVCImageType.UrlImage(
            image = "data:image/jpeg;base64,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",
            contentScale = null,
        )
        imageList = listOf(
            GSVCImageType.UrlImage(
                image = "data:image/jpeg;base64,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",
                background = Color.Red,
            ),
        )
        label = "Steren"
        description = "Celular Samsung 128Gb de Almacenamiento y 8Gb de Ram"
        prices = Pair(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W500,
                        textDecoration = TextDecoration.LineThrough,
                        color = SDAColor.GSVCInteractionDisable,
                    ),
                ) {
                    append("$1,169")
                }
            },
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append("$1,074")
                }
            },
        )
        body = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
            ) {
                append("$54")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 8.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    baselineShift = BaselineShift.Superscript,
                ),
            ) {
                append("80")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    color = SDAColor.GSVCInteractions,
                ),
            ) {
                append("\nPago semanal")
            }
        }
    },
)


val standAloneStore = listOf<GSSMAStandAloneGridModel>(
    GSSMAStandAloneGridModel(
        txttitle = "Relevantes",
        gssmaProductCardModel = relevantes,
    ),
    GSSMAStandAloneGridModel(
        txttitle = "Más reciente",
        gssmaProductCardModel = masrecientes,
    ),
    GSSMAStandAloneGridModel(
        txttitle = "Descuento",
        gssmaProductCardModel = descuento,
    ),
)


val categories = listOf(
    GSSMACategoriesStoreModel(
        imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/ofertas.png",
        txtCategorytitle = "Mujer",
        onCardClicked = {},
    ),
    GSSMACategoriesStoreModel(
        imgImgurl = "https://landing-piramide.superappbaz.com/Centro-Comercial/logos-Categorias/lineaBlanca.png",
        txtCategorytitle = "Zapatos \nde Hombre",
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


fun Pressclick(context: Context){

    Toast.makeText(context, "Back button clicked!", Toast.LENGTH_SHORT).show()
}