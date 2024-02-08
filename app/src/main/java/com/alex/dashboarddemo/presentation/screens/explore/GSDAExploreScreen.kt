@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.alex.dashboarddemo.presentation.screens.explore

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.common.widgets.GetStateScreen
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_EXPLORE

@Composable
fun GSDAExploreScreen() {
    val exploreVM: GSDAExploreViewModel = hiltViewModel()
    val state = exploreVM.uiState.collectAsState().value

    GetStateScreen(
        state = state,
        uiLoading = {
            GSDAShowLoading()
            exploreVM.setEvent(GSDAHomeContract.Event.OnInit(KEY_EXPLORE))
        },
        uiError = { GSDAShowError("Error") {} },
    )
}
