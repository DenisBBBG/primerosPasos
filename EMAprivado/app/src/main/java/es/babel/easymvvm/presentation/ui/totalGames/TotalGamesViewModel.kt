package es.babel.easymvvm.presentation.ui.totalGames

import es.babel.easymvvm.presentation.base.BaseViewModel

class TotalGamesViewModel() : BaseViewModel<TotalGamesState, TotalGamesNavigator.Navigation>() {
    override val initialViewState: TotalGamesState = TotalGamesState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    fun onCancelDialogTotalGames() {
        updateToNormalState()
    }

    fun onConfirmDialogTotalGames() {
        navigateBack()
    }
}