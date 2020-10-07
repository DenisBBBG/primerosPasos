package es.babel.easymvvm.presentation.ui.totalGames

import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseFragment
import org.kodein.di.generic.instance

class TotalGamesFragment() : BaseFragment<TotalGamesState, TotalGamesViewModel, TotalGamesNavigator.Navigation>() {
    override val layoutId: Int = es.babel.easymvvm.R.layout.total_games

    override val viewModelSeed: TotalGamesViewModel by instance()

    override val navigator: EmaBaseNavigator<TotalGamesNavigator.Navigation>? by instance()

    override fun onNormal(data: TotalGamesState) {
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: TotalGamesViewModel) {
    }

}