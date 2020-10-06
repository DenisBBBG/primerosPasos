package es.babel.easymvvm.presentation.ui.list

import androidx.navigation.NavController
import es.babel.easymvvm.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.presentation.ui.data.GameDataState

class GamesListNavigator(override val navController: NavController) : EmaNavigator<GamesListNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {
        class GameData(private val state: GameDataState) : GamesListNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as GamesListNavigator
                nav.toGameData(state)
            }
        }
    }
    fun toGameData(state: GameDataState) {
        navigateWithAction(R.id.navGraphAction_fragmentHome_to_gameData, addInputState(state))
    }
}


/*

class TelemedicineNavigator(
    override val navController: NavController
) :
    EmaNavigator<TelemedicineNavigator.Navigation> {
    sealed class Navigation : EmaNavigationState {
        class WaitingRoom(private val state: WaitingRoomViewState) : TelemedicineNavigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                val nav = navigator as TelemedicineNavigator
                nav.toWaitingRoom(state)
            }
        }
    }
    fun toWaitingRoom(state: WaitingRoomViewState) {
        navigateWithAction(R.id.action_telemedicineViewFragment_to_waitingRoomViewFragment, addInputState(state))
    }
}




 */