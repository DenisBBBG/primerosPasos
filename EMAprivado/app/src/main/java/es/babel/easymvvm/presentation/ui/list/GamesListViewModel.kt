package es.babel.easymvvm.presentation.ui.list

import es.babel.domain.model.GameModel
import es.babel.domain.usecase.GetGamesUseCase
import es.babel.easymvvm.presentation.base.BaseViewModel
import es.babel.easymvvm.presentation.ui.data.GameDataState


class GamesListViewModel(private val getGamesUseCase: GetGamesUseCase) : BaseViewModel<GamesListState, GamesListNavigator.Navigation>() {

    companion object {
        const val COMPLETE_URL = "https:"
    }

    override val initialViewState: GamesListState = GamesListState()

    override fun onStartFirstTime(statePreloaded: Boolean) {

        executeUseCaseWithException({
            val gameList = getGamesUseCase.execute(Unit)

            updateToNormalState {
                copy(
                        gameList = gameList
                )
            }

        }, { error ->
            updateToErrorState(error)

        })
        //Llamar al servicio

        /*Actualiza datos sin llamar a la vista, es decir que los cambios no se verian en pantalla
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
}