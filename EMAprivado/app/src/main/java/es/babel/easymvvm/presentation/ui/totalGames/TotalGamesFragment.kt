package es.babel.easymvvm.presentation.ui.totalGames

import es.babel.easymvvm.R
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.DIALOG_TAG_TOTAL_GAMES
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogListener
import es.babel.easymvvm.presentation.dialog.totalGames.TotalGamesDialogData
import es.babel.easymvvm.presentation.dialog.totalGames.TotalGamesDialogListener
import kotlinx.android.synthetic.main.fragment_games_list.*
import kotlinx.android.synthetic.main.total_games.*
import org.kodein.di.generic.instance

class TotalGamesFragment() : BaseFragment<TotalGamesState, TotalGamesViewModel, TotalGamesNavigator.Navigation>() {
    override val layoutId: Int = R.layout.total_games

    override val viewModelSeed: TotalGamesViewModel by instance()

    override val navigator: TotalGamesNavigator by instance()

    private val totalgamesDialog: EmaDialogProvider by instance(tag = DIALOG_TAG_TOTAL_GAMES)

    override fun onNormal(data: TotalGamesState) {
        totalgamesDialog.hide()
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: TotalGamesViewModel) {

        btnTotalGamesDialog.setOnClickListener {
            totalgamesDialog.show(TotalGamesDialogData(
                    title = getString(R.string.total_games_dialog_title),
                    message = getString(R.string.total_games_dialog_message),
                    info = "6548",
                    accept = getString(R.string.simple_game_list_dialog_accept),
                    cancel = getString(R.string.simple_game_list_dialog_cancel)))

            totalgamesDialog.dialogListener = object : TotalGamesDialogListener {
                override fun onCancelClicked() {
                    viewModel.onCancelDialogTotalGames()
                }

                override fun onConfirmClicked() {
                    viewModel.onConfirmDialogTotalGames()
                }

                override fun onBackPressed() {
                    viewModel.onCancelDialogTotalGames()

                }
            }
        }
    }
}