package es.babel.easymvvm.presentation.ui.home

import es.babel.easymvvm.presentation.base.BaseViewModel

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 20/1/19.
 */
class HomeViewModel : BaseViewModel<HomeState, HomeNavigator.Navigation>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    override val initialViewState: HomeState = HomeState()
}