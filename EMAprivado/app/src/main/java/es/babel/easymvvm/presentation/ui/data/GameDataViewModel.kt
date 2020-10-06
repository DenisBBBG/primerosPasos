package es.babel.easymvvm.presentation.ui.data

import es.babel.easymvvm.presentation.base.BaseViewModel

class GameDataViewModel() : BaseViewModel<GameDataState, GameDataNavigator.Navigation>() {

    override val initialViewState: GameDataState = GameDataState()

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }
}