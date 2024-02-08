package com.alex.dashboarddemo.presentation.screens.directory

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.dashboarddemo.mvi.GSDAHomeContract
import com.alex.dashboarddemo.presentation.common.components.GSDAShowError
import com.alex.dashboarddemo.presentation.common.components.GSDAShowLoading
import com.alex.dashboarddemo.presentation.common.widgets.GetStateScreen
import com.alex.dashboarddemo.utils.GSDAConstants.KEY_DIRECTORY

@Composable
fun GSDADirectoryScreen() {
    val directoryVM: GSDADirectoryViewModel = hiltViewModel()
    val state = directoryVM.uiState.collectAsState().value

    GetStateScreen(
        state = state,
        uiLoading = {
            directoryVM.setEvent(GSDAHomeContract.Event.OnInit(KEY_DIRECTORY))
            GSDAShowLoading()
        },
        uiError = { GSDAShowError(message = "Error") {} },
    )
}
