package es.babel.easymvvm.presentation.ui.lista

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.presentation.ui.home.EmaHomeNavigator

class GamesListNavigator(override  val navController: NavController) : EmaNavigator<EmaHomeNavigator.Navigation>{

    sealed class Navigation : EmaNavigationState{

    }
}