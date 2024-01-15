package com.alex.dashboarddemo.presentation.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alex.dashboarddemo.R
import com.alex.dashboarddemo.mvi.HomeContract
import com.alex.dashboarddemo.presentation.dashboard.header.GSDAHeaderModel
import com.alex.dashboarddemo.presentation.dashboard.header.GSSAHeader
import com.alex.dashboarddemo.presentation.navigation.AppBottomNavigation
import com.alex.dashboarddemo.presentation.navigation.NavigateScreens
import com.alex.dashboarddemo.ui.theme.JetDeliveryTheme
import com.clevertap.android.sdk.CleverTapAPI
import com.example.jetmoviesapp.presentation.navigation.Screen
import java.util.Date
import kotlinx.coroutines.flow.collectLatest

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val cleverTapDefaultInstance: CleverTapAPI? =
            CleverTapAPI.getDefaultInstance(applicationContext)
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG)
        // each of the below mentioned fields are optional
        val profileUpdate = HashMap<String, Any>()
        profileUpdate["Name"] = "Alejandro Pozas" // String
        profileUpdate["Identity"] = 61026032 // String or number
        profileUpdate["Email"] = "apozas@gmail.com" // Email address of the user
        profileUpdate["Phone"] = "+14155551234" // Phone (with the country code, starting with +)
        profileUpdate["Gender"] = "M" // Can be either M or F
        profileUpdate["DOB"] =
            Date() // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate["MSG-email"] = false // Disable email notifications
        profileUpdate["MSG-push"] = true // Enable push notifications
        profileUpdate["MSG-sms"] = false // Disable SMS notifications
        profileUpdate["MSG-whatsapp"] = true // Enable WhatsApp notifications
        val stuff = ArrayList<String>()
        stuff.add("bag")
        stuff.add("shoes")
        profileUpdate["MyStuff"] = stuff // ArrayList of Strings
        val otherStuff = arrayOf("Jeans", "Perfume")
        profileUpdate["MyStuff"] = otherStuff // String Array
        cleverTapDefaultInstance?.pushProfile(profileUpdate)
        println("Hola clevertap")

        setContent {
            DashboardApp(viewModel)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardApp(viewModel: MainViewModel) {
    val scope = rememberCoroutineScope()

    val showRandom by remember { mutableStateOf(false) }
    val state = viewModel.uiState

    LaunchedEffect(scope) {
        state.collectLatest {
            when (it.getInfo) {
                HomeContract.DashBoardApiState.Idle -> {
                    println("Cargando")
                }

                is HomeContract.DashBoardApiState.OnNavigate -> {
                    println("Navegando a la ruta de  ${it.getInfo.route}")
                }
            }
        }
    }

    LaunchedEffect(scope) {
        viewModel.setEvent(HomeContract.Event.OnInit(showRandom))
    }

    val showBottomBar = rememberSaveable { mutableStateOf(true) }
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    JetDeliveryTheme {
        Scaffold(
            topBar = {
                val headerModelPreview =
                    GSDAHeaderModel(
                        name = "Andrea",
                        points = "200",
                        rewardsIndicator = true,
                        notificationsIndicator = true,
                        urlProfile = R.drawable.personperfil,
                        urlNotification = R.drawable.baseline_notifications_24,
                        urlRewards = R.drawable.ic_gema
                    )

                GSSAHeader(headerModel = headerModelPreview)
            },
            bottomBar = {
                showBottomBar.value =
                    when (currentDestination?.route?.substringBeforeLast("/")) {
                        Screen.MovieDetail.route -> false
                        else -> true
                    }
                AnimatedVisibility(
                    visible = showBottomBar.value,
                    enter = slideInVertically(initialOffsetY = { it }),
                    exit = slideOutVertically(targetOffsetY = { it })
                ) {
                    AppBottomNavigation(
                        navController = navController,
                        currentDestination = currentDestination
                    )
                }
            },
            backgroundColor = Color(0xFFE2E2E2)
        ) {
            NavigateScreens(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

/**
 * cargar secciones mediante composable list
 *
sealed class Sections {
data class Pagos(val innerServices: @Composable () -> Unit = {}) : Sections()
data class Credito(val innerServices: @Composable () -> Unit = {}) : Sections()
data class Tienda(val innerServices: @Composable () -> Unit = {}) : Sections()
data class Diversion(val innerServices: @Composable () -> Unit = {}) : Sections()
data class Explora(val innerServices: @Composable () -> Unit = {}) : Sections()
}
con la finalidad de implementar
couchmark
/walktrought ademas de un scrollToSection(Item)
 */
