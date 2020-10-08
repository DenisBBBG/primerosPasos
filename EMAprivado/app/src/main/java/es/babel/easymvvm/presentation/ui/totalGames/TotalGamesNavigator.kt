package es.babel.easymvvm.presentation.ui.totalGames

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class TotalGamesNavigator(override val navController: NavController) : EmaNavigator<TotalGamesNavigator.Navigation> {
    sealed class Navigation : EmaNavigationState
}