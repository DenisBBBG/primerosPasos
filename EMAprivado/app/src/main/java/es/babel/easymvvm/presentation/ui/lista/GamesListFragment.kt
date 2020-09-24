package es.babel.easymvvm.presentation.ui.lista

import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseFragment
import org.kodein.di.generic.instance


class GamesListFragment : BaseFragment<GamesListState, GamesListViewModel, GamesListNavigator.Navigation>() {


    override val layoutId: Int = es.babel.easymvvm.R.layout.fragment_games_list

    override val viewModelSeed: GamesListViewModel by instance()

    override val navigator: EmaBaseNavigator<GamesListNavigator.Navigation>? by instance()



    override fun onNormal(data: GamesListState) {

    }

    override fun onAlternative(data: EmaExtraData) {

    }

    override fun onSingle(data: EmaExtraData) {

    }

    override fun onError(error: Throwable) {

    }

    override fun onInitialized(viewModel: GamesListViewModel) {

    }


}