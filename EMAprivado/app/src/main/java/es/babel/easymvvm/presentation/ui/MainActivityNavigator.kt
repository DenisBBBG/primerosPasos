package es.babel.easymvvm.presentation.ui

import androidx.navigation.NavController
import es.babel.easymvvm.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.presentation.ui.list.GamesListState

class MainActivityNavigator(override val navController: NavController) : EmaNavigator<MainActivityNavigator.Navigation> {
    sealed class Navigation : EmaNavigationState {

        class GamesList : MainActivityNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainActivityNavigator
                nav.toHomeFragment()
            }
        }

        class TotalGames : MainActivityNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as MainActivityNavigator
                nav.toTotalGamesFragment()
            }
        }
    }

    fun toHomeFragment() {
        navigateWithAction(R.id.action_global_gamesListFragment)
    }

    fun toTotalGamesFragment() {
        navigateWithAction(R.id.action_global_totalGamesFragment)
    }
}