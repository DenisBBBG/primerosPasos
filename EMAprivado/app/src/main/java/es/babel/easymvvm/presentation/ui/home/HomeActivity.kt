package es.babel.easymvvm.presentation.ui.home

import es.babel.easymvvm.R
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.presentation.base.BaseActivity
import org.kodein.di.generic.instance

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */
class HomeActivity : BaseActivity<HomeState, HomeViewModel, HomeNavigator.Navigation>() {

    override val navGraph: Int = R.navigation.navigation_home

    override fun onInitialized(viewModel: HomeViewModel) {

    }

    override fun provideFixedToolbarTitle(): String? = getString(R.string.home_toolbar_title)

    /**
     * Variable used to enable the theme used in manifest. Otherwise it will use the EmaTheme,
     * It is set as true by default.
     */
    override val overrideTheme: Boolean = false

    override val viewModelSeed: HomeViewModel by instance()

    override val navigator: HomeNavigator by instance()

    override fun onStateNormal(data: HomeState) {
        setToolbarTitle(data.toolbarTitle)

    }

    override fun onStateAlternative(data: EmaExtraData) {

    }



    override fun onSingleEvent(data: EmaExtraData) {

    }

    override fun onStateError(error: Throwable) {

    }
}