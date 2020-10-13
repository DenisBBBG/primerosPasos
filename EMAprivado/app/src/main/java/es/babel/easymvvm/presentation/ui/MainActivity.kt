package es.babel.easymvvm.presentation.ui

import es.babel.easymvvm.R
import es.babel.easymvvm.android.extra.EmaReceiverModel
import es.babel.easymvvm.android.extra.EmaResultModel
import es.babel.easymvvm.android.ui.EmaView
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_base.*
import org.kodein.di.generic.instance

class MainActivity : BaseActivity(), EmaView<MainActivityState, MainActivityViewModel, MainActivityNavigator.Navigation> {

    override fun provideFixedToolbarTitle(): String? = null

    override val layoutId: Int = R.layout.activity_base

    override val navGraph: Int = R.navigation.navigation_home

    override val viewModelSeed: MainActivityViewModel by instance()

    override val navigator: EmaBaseNavigator<MainActivityNavigator.Navigation>? by instance()

    override val inputState: MainActivityState? = MainActivityState()

    override var previousState: MainActivityState? = null


    override fun onViewModelInitialized(viewModel: MainActivityViewModel) {

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_home -> {
                    MainActivityNavigator.Navigation.GamesList()
                }

                R.id.page_total_games -> {
                    MainActivityNavigator.Navigation.TotalGames()
                }
            }
            true
        }
    }

    override fun onStateNormal(data: MainActivityState) {


    }

    override fun onStateAlternative(data: EmaExtraData) {
    }

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onStateError(error: Throwable) {
    }

    override fun onResultSetEvent(emaResultModel: EmaResultModel) {
    }

    override fun onResultReceiverInvokeEvent(emaReceiverModel: EmaReceiverModel) {
    }

}