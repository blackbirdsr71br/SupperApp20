package com.alex.dashboarddemo.mvi

class HomeContract {

    // Events that user performed (view -> viewmodel)
    sealed class Event : UiEvent {
        data class OnInit(val downloading: Boolean) : Event()
        data class OnUpdate(val pair: String) : Event()
        data class OnNavigate(val route: String) : Event()
    }

    // Ui View States
    data class DashBoardState(
        val getInfo: DashBoardApiState,
    ) : UiState

    // View State that related to Random Number
    sealed class DashBoardApiState { // (viewmodel ->view)

        object Idle : DashBoardApiState()
        data class OnNavigate(val route: String) : DashBoardApiState()
    }

    // Side effects
    sealed class Effect : UiEffect {

        object ShowToast : Effect()
    }
}
