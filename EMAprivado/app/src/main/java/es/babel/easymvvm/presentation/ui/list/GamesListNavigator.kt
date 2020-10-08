package es.babel.easymvvm.presentation.ui.list

import androidx.navigation.NavController
import es.babel.easymvvm.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.presentation.ui.data.GameDataState
import es.babel.easymvvm.presentation.ui.totalGames.TotalGamesState

class GamesListNavigator(override val navController: NavController) : EmaNavigator<GamesListNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        class GameData(private val state: GameDataState) : GamesListNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as GamesListNavigator
                nav.toGameData(state)
            }
        }

        class TotalGames(private val state: TotalGamesState) : GamesListNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as GamesListNavigator
                nav.toTotalGames(state)
            }
        }
    }

    fun toGameData(state: GameDataState) {
        navigateWithAction(R.id.navGraphAction_fragmentHome_to_gameData, addInputState(state))
    }

    fun toTotalGames(state: TotalGamesState) {
        navigateWithAction(R.id.action_gamesListFragment_to_totalGamesFragment, addInputState(state))
    }
}