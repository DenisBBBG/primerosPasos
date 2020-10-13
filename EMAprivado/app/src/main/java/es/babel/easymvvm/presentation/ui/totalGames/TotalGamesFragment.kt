package es.babel.easymvvm.presentation.ui.totalGames

import es.babel.easymvvm.R
import es.babel.easymvvm.core.dialog.EmaDialogProvider
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.DIALOG_TAG_TOTAL_GAMES
import es.babel.easymvvm.presentation.base.BaseFragment
import es.babel.easymvvm.presentation.dialog.totalGames.TotalGamesDialogData
import es.babel.easymvvm.presentation.dialog.totalGames.TotalGamesDialogListener
import es.babel.easymvvm.presentation.ui.totalGames.TotalGamesViewModel.Companion.TOTAL_GAMES_DIALOG
import kotlinx.android.synthetic.main.total_games.*
import org.kodein.di.generic.instance

class TotalGamesFragment : BaseFragment<TotalGamesState, TotalGamesViewModel, TotalGamesNavigator.Navigation>() {
    override val layoutId: Int = R.layout.total_games

    override val viewModelSeed: TotalGamesViewModel by instance()

    override val navigator: TotalGamesNavigator by instance()

    private val totalGamesDialog: EmaDialogProvider by instance(tag = DIALOG_TAG_TOTAL_GAMES)

    private lateinit var viewModel: TotalGamesViewModel

    override fun onNormal(data: TotalGamesState) {
        totalGamesDialog.hide()
    }

    override fun onAlternative(data: EmaExtraData) {
        when (data.type) {
            TOTAL_GAMES_DIALOG -> {
                totalGamesDialog.show(TotalGamesDialogData(
                        title = getString(R.string.total_games_dialog_title),
                        message = getString(R.string.total_games_dialog_message),
                        info = data.extraData.toString(),
                        accept = getString(R.string.simple_game_list_dialog_accept),
                        cancel = getString(R.string.simple_game_list_dialog_cancel)))

                totalGamesDialog.dialogListener = object : TotalGamesDialogListener {
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

    override fun onSingle(data: EmaExtraData) {
    }

    override fun onError(error: Throwable) {
    }

    override fun onInitialized(viewModel: TotalGamesViewModel) {
        this.viewModel = viewModel
        btnTotalGamesDialog.setOnClickListener {
            viewModel.onTotalGamesDialogShow()
        }
    }
}