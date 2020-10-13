package es.babel.easymvvm.presentation.ui

import es.babel.easymvvm.presentation.base.BaseViewModel

class MainActivityViewModel : BaseViewModel<MainActivityState, MainActivityNavigator.Navigation>() {
    override val initialViewState: MainActivityState = MainActivityState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }
}