package com.alex.dashboarddemo.presentation.screens.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.common.widgets.GetStateScreen
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_PROFILE

@Composable
fun GSDAProfileScreen() {
    val profileVM: GSDAProfileViewModel = hiltViewModel()
    val state = profileVM.uiState.collectAsState().value

    GetStateScreen(
        state = state,
        uiLoading = {
            profileVM.setEvent(GSDAHomeContract.Event.OnInit(KEY_PROFILE))
            GSDAShowLoading()
        },
        uiError = { GSDAShowError(message = "Error") {} },
    )
}
