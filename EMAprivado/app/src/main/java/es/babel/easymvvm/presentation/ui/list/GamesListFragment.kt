package es.babel.easymvvm.presentation.ui.list

import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import es.babel.domain.model.GameModel
import es.babel.easymvvm.R
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.DIALOG_TAG_LOADING
import es.babel.easymvvm.presentation.DIALOG_TAG_SIMPLE
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.dialog.loading.LoadingDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogListener
import es.babel.easymvvm.presentation.ui.list.GamesListViewModel.Companion.SIMPLE_DIALOG
import kotlinx.android.synthetic.main.fragment_games_list.*
import org.kodein.di.generic.instance

class GamesListFragment : BaseFragment<GamesListState, GamesListViewModel, GamesListNavigator.Navigation>() {
    override val layoutId: Int = R.layout.fragment_games_list

    override val viewModelSeed: GamesListViewModel by instance()

    override val navigator: GamesListNavigator by instance()

    private lateinit var viewModel: GamesListViewModel

    private val loadingDialog: EmaDialogProvider by instance(tag = DIALOG_TAG_LOADING)

    private val navigateTotalGamesDialog: EmaDialogProvider by instance(tag = DIALOG_TAG_SIMPLE)

    override fun onNormal(data: GamesListState) {
        //Siempre que se realice cualquier accion de este fragmento, pasas por aqui
        data.gameList?.let {
            rvFragmentHomeGames.adapter = GamesAdapter(viewModel, it as MutableList<GameModel>)
        }

        loadingDialog.hide()
        navigateTotalGamesDialog.hide()
    }

    override fun onAlternative(data: EmaExtraData) {
        when (data.type) {
            SIMPLE_DIALOG -> {
                navigateTotalGamesDialog.show(SimpleDialogData(
                        title = getString(R.string.simple_game_list_dialog_title),
                        accept = getString(R.string.simple_game_list_dialog_accept),
                        cancel = getString(R.string.simple_game_list_dialog_cancel)))

                navigateTotalGamesDialog.dialogListener = object : SimpleDialogListener {
                    override fun onCancelClicked() {
                        viewModel.onCancelDialogToTotalGames()
                    }

                    override fun onConfirmClicked() {
                        viewModel.onConfirmDialogToTotalGames()
                    }

                    override fun onBackPressed() {
                        viewModel.onCancelDialogToTotalGames()
                    }
                }
            }
            else -> loadingDialog.show(LoadingDialogData(title = getString(R.string.loading_game_list_dialog_title)))
        }
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: GamesListViewModel) {
        //OnViewCreated , (al arrancar el fragmento)
        this.viewModel = viewModel
        rvFragmentHomeGames.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        etGameListSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.filterGames(s.toString())
            }
        })

        srlGamesList.setOnRefreshListener {
            viewModel.refreshGameList()
            srlGamesList.isRefreshing = false
        }

        btnGameListSimpleDialogToTotalGames.setOnClickListener {
            viewModel.onSimpleDialogShow()
        }
    }
}
