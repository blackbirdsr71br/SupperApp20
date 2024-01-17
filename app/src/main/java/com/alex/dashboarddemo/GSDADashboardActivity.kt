package com.alex.dashboarddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.alex.dashboarddemo.presentation.screens.main.GSDADashboardScreen
import com.alex.dashboarddemo.presentation.screens.main.GSDADashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val dashboardVM: GSDADashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GSDADashboardScreen(dashboardVM)
        }
    }
}
