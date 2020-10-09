package es.babel.easymvvm.presentation.ui.totalGames

import es.babel.domain.usecase.GetTotalGamesUseCase
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseViewModel

class TotalGamesViewModel(private val getTotalGamesUseCase: GetTotalGamesUseCase) : BaseViewModel<TotalGamesState, TotalGamesNavigator.Navigation>() {
    override val initialViewState: TotalGamesState = TotalGamesState()

    companion object {
        const val TOTAL_GAMES_DIALOG = 1
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {

        executeUseCaseWithException({
            val totalGames = getTotalGamesUseCase.execute(Unit)

            updateToNormalState {
                copy(
                        totalGames = totalGames.count.toString()
                )
            }
        }, { error ->
            updateToErrorState(error)
        })
    }

    fun onCancelDialogTotalGames() {
        updateToNormalState()
    }

    fun onConfirmDialogTotalGames() {
        updateToNormalState()
        navigateBack()
    }

    fun onTotalGamesDialogShow() {
        checkDataState {
            updateToAlternativeState(EmaExtraData(TOTAL_GAMES_DIALOG,it.totalGames))
        }
    }
}