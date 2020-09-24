package es.babel.easymvvm.presentation.ui.lista

import es.babel.easymvvm.presentation.base.BaseViewModel

class GamesListViewModel : BaseViewModel<GamesListState, GamesListNavigator.Navigation> () {

    override val initialViewState: GamesListState = GamesListState()

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }


}