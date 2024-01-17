package com.alex.dashboarddemo.data.mockdata

import androidx.compose.ui.graphics.Color
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.domain.model.GSDAItem
import com.alex.dashboarddemo.presentation.dashboard.GSVCFlatCard
import com.alex.dashboarddemo.presentation.dashboard.GSVCFlatCardType
import com.alex.dashboarddemo.presentation.dashboard.gsdaProductSlider.GSDAProductInfoCardModel
import com.alex.dashboarddemo.presentation.dashboard.gsdaPromoSlider.GSDAPromoInfoCardModel
import com.alex.dashboarddemo.presentation.dashboard.paymentscarousel.GSDAPaymentCarouselCardModel
import com.alex.dashboarddemo.presentation.stories.Tweet
import com.alex.dashboarddemo.ui.theme.GSVCBase100
import com.alex.dashboarddemo.ui.theme.GSVCSecondary100
import com.alex.dashboarddemo.ui.theme.GSVCTitleBase100Left
import com.alex.dashboarddemo.ui.theme.Purple500

object DemoDataProvider {
    val GSDAItemModelLists = listOf(
        GSDAItem(
            1,
            "Fresh Vegges and Greens",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food1,
        ),
        GSDAItem(
            2,
            "Best blue berries",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food2,
        ),
        GSDAItem(
            3,
            "Cherries La Bloom",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food3,
        ),
        GSDAItem(
            4,
            "Fruits everyday",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food4,
        ),
        GSDAItem(
            5,
            "Sweet and sour",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food5,
        ),
        GSDAItem(
            6,
            "Pancakes for everyone",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food6,
        ),
        GSDAItem(
            7,
            "Cupcakes and sparkle",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food7,
        ),
        GSDAItem(
            8,
            "Best Burgers shop",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food8,
        ),
        GSDAItem(
            9,
            "Coffee of India",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food9,
        ),
        GSDAItem(
            10,
            "Pizza boy town",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food10,
        ),
        GSDAItem(
            11,
            "Burgers and Chips",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food11,
        ),
        GSDAItem(
            12,
            "Breads and butter",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food12,
        ),
        GSDAItem(
            13,
            "Cupcake factory",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food13,
        ),
        GSDAItem(
            14,
            "Breakfast paradise",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food14,
        ),
        GSDAItem(
            15,
            "Cake and Bake",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food15,
        ),
        GSDAItem(
            16,
            "Brunch and Stakes",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food16,
        ),
    )

    val GSDAItemModel = GSDAItem(
        1,
        "Awesome List Item",
        "Very awesome list item has very awesome subtitle. This is bit long",
        R.drawable.food6,
    )

    val tweet = Tweet(
        1,
        "Jetpack compose is the next thing for andorid. Declarative UI is the way to go for all screens.",
        "The Verge",
        "@verge",
        "12m",
        R.drawable.food1,
        100,
        12,
        15,
        "Twitter for web",
    )

    val tweetList = listOf(
        tweet,
        tweet.copy(
            id = 2,
            author = "Google",
            handle = "@google",
            authorImageId = R.drawable.p1,
            tweetImageId = R.drawable.food16,
            time = "11m",
        ),
        tweet.copy(
            id = 3,
            author = "Amazon",
            handle = "@Amazon",
            authorImageId = R.drawable.p2,
            time = "1h",
        ),
        tweet.copy(
            id = 4,
            author = "Facebook",
            handle = "@Facebook",
            authorImageId = R.drawable.p3,
            time = "1h",
        ),
        tweet.copy(
            id = 5,
            author = "Instagram",
            handle = "@Instagram",
            authorImageId = R.drawable.p4,
            tweetImageId = R.drawable.food15,
            time = "11m",
        ),
        tweet.copy(
            id = 6,
            author = "Twitter",
            handle = "@Twitter",
            authorImageId = R.drawable.p5,
            tweetImageId = R.drawable.food3,
            time = "11m",
        ),
        tweet.copy(
            id = 7,
            author = "Netflix",
            handle = "@Netflix",
            authorImageId = R.drawable.p6,
            tweetImageId = R.drawable.food4,
            time = "11m",
        ),
        tweet.copy(
            id = 8,
            author = "Tesla",
            handle = "@Tesla",
            authorImageId = R.drawable.p7,
            time = "1h",
        ),
        tweet.copy(
            id = 9,
            author = "Microsoft",
            handle = "@Microsoft",
            authorImageId = R.drawable.p8,
            time = "1h",
        ),
        tweet.copy(
            id = 3,
            author = "Tencent",
            handle = "@Tencent",
            authorImageId = R.drawable.p5,
            time = "1h",
        ),
        tweet.copy(
            id = 4,
            author = "Snapchat",
            handle = "@Snapchat",
            authorImageId = R.drawable.p10,
            time = "1h",
        ),
        tweet.copy(
            id = 5,
            author = "Snapchat",
            handle = "@Snapchat",
            authorImageId = R.drawable.p11,
            tweetImageId = R.drawable.food5,
            time = "11m",
        ),
        tweet.copy(
            id = 6,
            author = "Tiktok",
            handle = "@Tiktok",
            authorImageId = R.drawable.p1,
            tweetImageId = R.drawable.food6,
            time = "11m",
        ),
        tweet.copy(
            id = 7,
            author = "Samsung",
            handle = "@Samsung",
            authorImageId = R.drawable.p2,
            tweetImageId = R.drawable.food7,
            time = "11m",
        ),
        tweet.copy(
            id = 8,
            author = "Youtube",
            handle = "@Youtube",
            authorImageId = R.drawable.p3,
            time = "1h",
        ),
        tweet.copy(
            id = 9,
            author = "Gmail",
            handle = "@Gmail",
            authorImageId = R.drawable.p4,
            time = "1h",
        ),
        tweet.copy(
            id = 3,
            author = "Android",
            handle = "@Android",
            authorImageId = R.drawable.p5,
            time = "1h",
        ),
        tweet.copy(
            id = 4,
            author = "Whatsapp",
            handle = "@Whatsapp",
            authorImageId = R.drawable.p6,
            time = "1h",
        ),
        tweet.copy(
            id = 5,
            author = "Telegram",
            handle = "@Telegram",
            authorImageId = R.drawable.p7,
            tweetImageId = R.drawable.food8,
            time = "11m",
        ),
        tweet.copy(
            id = 6,
            author = "Spotify",
            handle = "@Spotify",
            authorImageId = R.drawable.p8,
            tweetImageId = R.drawable.food9,
            time = "11m",
        ),
        tweet.copy(
            id = 7,
            author = "WeChat",
            handle = "@WeChat",
            authorImageId = R.drawable.p5,
            tweetImageId = R.drawable.food10,
            time = "11m",
        ),
        tweet.copy(
            id = 8,
            author = "Airbnb",
            handle = "@Airbnb",
            authorImageId = R.drawable.p10,
            time = "1h",
        ),
        tweet.copy(
            id = 9,
            author = "LinkedIn",
            handle = "@LinkedIn",
            authorImageId = R.drawable.p11,
            time = "1h",
        ),
        tweet.copy(
            id = 6,
            author = "Shazam",
            handle = "@Shazam",
            authorImageId = R.drawable.p8,
            tweetImageId = R.drawable.food11,
            time = "11m",
        ),
        tweet.copy(
            id = 7,
            author = "Chrome",
            handle = "@Chrome",
            authorImageId = R.drawable.p5,
            tweetImageId = R.drawable.food12,
            time = "11m",
        ),
        tweet.copy(
            id = 6,
            author = "Safari",
            handle = "@Safari",
            authorImageId = R.drawable.p8,
            tweetImageId = R.drawable.food13,
            time = "11m",
        ),
        tweet.copy(
            id = 7,
            author = "Disney",
            handle = "@Disney",
            authorImageId = R.drawable.p5,
            tweetImageId = R.drawable.food14,
            time = "11m",
        ),
    )

    val gsdaInfoCardList = listOf(
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Necesitas un Crédito?",
            subtitleInfo = "Te prestamos hasta $12,000 de inmediato",
            buttonText = "Solicitalo ahora",
            onButtonClick =
            {},
        ),
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Quieres un seguro?",
            subtitleInfo = "Te ofrecomos los mejores seguros",
            buttonText = "Solicitalo Ya!",
            onButtonClick =
            {},
        ),
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Quieres comprar a crédito?",
            subtitleInfo = "Tenemos los mejores créditos",
            buttonText = "Solicitalo con baz",
            onButtonClick =
            {},
        ),
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Sin saldo?",
            subtitleInfo = "En baz tenemos las mejores compañías",
            buttonText = "Recarga Saldo",
            onButtonClick =
            {},
        ),
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Tienes Inversión?",
            subtitleInfo = "En banco azteca tenemos lo mejor",
            buttonText = "Crea tu inversión",
            onButtonClick =
            {},
        ),
        GSDAPromoInfoCardModel(
            chipInfo = "Anuncio",
            chipBackground = Purple500,
            chipTextColor = GSVCBase100,
            titleInfo = "¿Necesitas un Crédito?",
            subtitleInfo = "Te prestamos hasta $12,000 de inmediato",
            buttonText = "Solicitalo ahora",
            onButtonClick =
            {},
        ),
    )

    val gsdaProductInfoCardList = listOf(
        GSDAProductInfoCardModel(
            chipInfo = "Promociones · Envio gratis",
            chipBackground = Purple500,
            productDescription = "Samsung Galaxy A23 128GB Libre",
            weekPayment = "$104",
            aditionalInfo = "Pago semanal con crédito",
        ),
        GSDAProductInfoCardModel(
            chipInfo = "Promociones · Envio gratis",
            chipBackground = GSVCSecondary100,
            productDescription = "Iphone 14  128GB Libre",
            weekPayment = "$214",
            aditionalInfo = "Pago semanal con crédito",
        ),
        GSDAProductInfoCardModel(
            chipInfo = "Promociones · Envio gratis",
            chipBackground = GSVCSecondary100,
            productDescription = "Refigerador Samsung 14 pies",
            weekPayment = "$114",
            aditionalInfo = "Pago semanal con crédito",
        ),
        GSDAProductInfoCardModel(
            chipInfo = "Promociones · Envio gratis",
            chipBackground = GSVCSecondary100,
            productDescription = "Pantalla Sony LCD Smart TV 55 pulg ",
            weekPayment = "$214",
            aditionalInfo = "Pago semanal con crédito",
        ),
        GSDAProductInfoCardModel(
            chipInfo = "Promociones · Envio gratis",
            chipBackground = GSVCSecondary100,
            productDescription = "Lavadora Mabe 16 KG Pragmatic",
            weekPayment = "$164",
            aditionalInfo = "Pago semanal con crédito",
        ),
        GSDAProductInfoCardModel(
            productDescription = "",
            weekPayment = "",
            aditionalInfo = "",
        ),
    )

    val gsdaPaymentsCardList = listOf(

        GSDAPaymentCarouselCardModel(
            "Alcancías",
            R.drawable.gsda_ic_paymentcarousel_image1,
        ),
        GSDAPaymentCarouselCardModel(
            "Sobres",
            R.drawable.gsda_ic_paymentcarousel_image2,
        ),
        GSDAPaymentCarouselCardModel(
            "Alcancías grupales",
            R.drawable.gsda_ic_paymentcarousel_image1,
        ),
        GSDAPaymentCarouselCardModel(
            "Alcancías",
            R.drawable.gsda_ic_paymentcarousel_image2,
        ),
        GSDAPaymentCarouselCardModel(
            "Sobres",
            R.drawable.gsda_ic_paymentcarousel_image1,
        ),
        GSDAPaymentCarouselCardModel(
            "Alcancías grupales",
            R.drawable.gsda_ic_paymentcarousel_image2,
        ),
    )

    val ProductList = listOf(
        GSDAItem(
            1,
            "Fresh Vegges and Greens",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.galaxya23,
        ),
        GSDAItem(
            2,
            "Best blue berries",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.iphone14,
        ),
        GSDAItem(
            3,
            "Cherries La Bloom",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.refrigerador,
        ),
        GSDAItem(
            4,
            "Fruits everyday",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.pantalla,
        ),
        GSDAItem(
            5,
            "Sweet and sour",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.lavadora,
        ),
        GSDAItem(
            6,
            "Pancakes for everyone",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food6,
        ),
        GSDAItem(
            7,
            "Cupcakes and sparkle",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food7,
        ),
        GSDAItem(
            8,
            "Best Burgers shop",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food8,
        ),
        GSDAItem(
            9,
            "Coffee of India",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food9,
        ),
        GSDAItem(
            10,
            "Pizza boy town",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food10,
        ),
        GSDAItem(
            11,
            "Burgers and Chips",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food11,
        ),
        GSDAItem(
            12,
            "Breads and butter",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food12,
        ),
        GSDAItem(
            13,
            "Cupcake factory",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food13,
        ),
        GSDAItem(
            14,
            "Breakfast paradise",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food14,
        ),
        GSDAItem(
            15,
            "Cake and Bake",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food15,
        ),
        GSDAItem(
            16,
            "Brunch and Stakes",
            "Very awesome list item has very awesome subtitle. This is bit long",
            R.drawable.food16,
        ),
    )

    val gridlist1 = listOf<GSVCFlatCard>(
        GSVCFlatCard(
            featureMessage = "Nuevo",
            image = R.drawable.baseline_bedtime_24,
            message = "Soy la primer tarjeta",
            route = "Tarjeta 1",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 2",
            route = "Tarjeta 2",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Recarga tiempo aire",
            route = "Tarjeta 3",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 4",
            route = "Tarjeta 4",
        ),
        GSVCFlatCard(
            BgCardColor = Color.Black,
            style = GSVCTitleBase100Left,
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 5",
            route = "Tarjeta 5",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 6",
            route = "Tarjeta 6",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 7",
            route = "Tarjeta 7",
        ),
        GSVCFlatCard(
            style = GSVCTitleBase100Left,
            BgCardColor = Color.Black,
            image = R.drawable.baseline_bedtime_24,
            message = "Tarjeta 8",
            route = "Tarjeta 8",
        ),
        GSVCFlatCard(
            image = R.drawable.baseline_bedtime_24,
            message = "Soy la ultima tarjeta",
            size = GSVCFlatCardType.COMPOSABLE,
            content = {
            },
            route = "Tarjeta 9",
        ),
    )
}
