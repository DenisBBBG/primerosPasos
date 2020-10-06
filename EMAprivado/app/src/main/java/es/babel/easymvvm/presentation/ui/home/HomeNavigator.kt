package es.babel.easymvvm.presentation.ui.home

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class HomeNavigator(override  val navController: NavController) : EmaNavigator<HomeNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

    }
}