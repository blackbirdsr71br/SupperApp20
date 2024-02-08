package com.alex.dashboarddemo.presentation.screens.credit

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.common.widgets.GetStateScreen
import com.alex.dashboarddemo.presentation.screens.explore.GSDAExploreViewModel
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_CREDIT

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GSDACreditScreen() {
    val creditVM: GSDAExploreViewModel = hiltViewModel()
    val state = creditVM.uiState.collectAsState().value

    GetStateScreen(
        state = state,
        uiLoading = {
            GSDAShowLoading()
            creditVM.setEvent(GSDAHomeContract.Event.OnInit(KEY_CREDIT))
        },
        uiError = { GSDAShowError(message = "Error") {} },
    )
}
