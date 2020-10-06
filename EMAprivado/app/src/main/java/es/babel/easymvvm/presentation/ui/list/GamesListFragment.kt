package es.babel.easymvvm.presentation.ui.list

import androidx.recyclerview.widget.LinearLayoutManager
import es.babel.easymvvm.R
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_games_list.*
import org.kodein.di.generic.instance

class GamesListFragment : BaseFragment<GamesListState, GamesListViewModel, GamesListNavigator.Navigation>() {
    override val layoutId: Int = R.layout.fragment_games_list

    override val viewModelSeed: GamesListViewModel by instance()

    override val navigator: GamesListNavigator by instance()

    private lateinit var viewModel: GamesListViewModel

    override fun onNormal(data: GamesListState) {
        //Siempre uqe se realice cualquier accion de este fragmento, pasas por aqui
        rvFragmentHomeGames.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        data.gameList?.let {
            rvFragmentHomeGames.adapter = GamesAdapter(it, viewModel)
        }
    }

    override fun onAlternative(data: EmaExtraData) {
        //
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: GamesListViewModel) {
        //OnViewCreated , (al arrancar el fragmento)
        this.viewModel = viewModel
    }
}