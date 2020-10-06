package es.babel.easymvvm.presentation.ui.data

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class GameDataNavigator(override val navController: NavController) : EmaNavigator<GameDataNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState
}
