package com.alex.dashboarddemo.presentation.screens.benefits

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.common.widgets.GetStateScreen
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_BENEFITS

@Composable
fun GSDABenefitsScreen() {
    val benefitsVM: GSDABenefitsViewModel = hiltViewModel()
    val state = benefitsVM.uiState.collectAsState().value

    GetStateScreen(
        state = state,
        uiLoading = {
            GSDAShowLoading()
            benefitsVM.setEvent(GSDAHomeContract.Event.OnInit(KEY_BENEFITS))
        },
        uiError = { GSDAShowError(message = "Error") {} },
    )
}
