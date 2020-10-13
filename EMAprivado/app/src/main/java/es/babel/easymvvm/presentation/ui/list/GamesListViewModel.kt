package es.babel.easymvvm.presentation.ui.list

import es.babel.domain.model.GameModel
import es.babel.domain.usecase.GetGamesUseCase
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseViewModel
import es.babel.easymvvm.presentation.ui.data.GameDataState
import es.babel.easymvvm.presentation.ui.totalGames.TotalGamesState

class GamesListViewModel(private val getGamesUseCase: GetGamesUseCase) : BaseViewModel<GamesListState, GamesListNavigator.Navigation>() {
    override val initialViewState: GamesListState = GamesListState()

    private lateinit var fullGameList: List<GameModel>

    companion object {
        const val SIMPLE_DIALOG = 1
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
        refreshGameList()

/*Llamar al servicio
Actualiza datos sin llamar a la vista, es decir que los cambios no se verian en pantalla
updateDataState {
     }

Actualiza los datos igual que la funcion anterior pero tambien actualiza la vista
updateToNormalState {
    copy(/aqui se ponen variables que queremos actualizar/)
    actualizar variable del estado con lo que me evuelve el servicio
}
 */
    }

    fun onGameItemClick(game: GameModel) {
        navigate(
                GamesListNavigator.Navigation.GameData(
                        GameDataState(game)
                )
        )
    }

    fun filterGames(filter: String) {
        updateToNormalState {
            copy(
                    gameList = fullGameList.filter { game ->
                        game.title?.contains(filter, ignoreCase = true) ?: false
                    }
            )
        }
    }

    fun refreshGameList() {
        updateToAlternativeState()

        executeUseCaseWithException({
            val gameList = getGamesUseCase.execute(Unit)

            fullGameList = gameList

            updateToNormalState {
                copy(
                        gameList = gameList
                )
            }
        }, { error ->
            updateToErrorState(error)
        })
    }

    fun onCancelDialogToTotalGames() {
        updateToNormalState()
    }

    fun onConfirmDialogToTotalGames() {
        updateToNormalState()
        navigate(
                GamesListNavigator.Navigation.TotalGames(
                        TotalGamesState()
                )
        )
    }

    fun onSimpleDialogShow() {
        updateToAlternativeState(EmaExtraData(SIMPLE_DIALOG))

    }
}