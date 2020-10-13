package es.babel.easymvvm.presentation.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

abstract class BaseViewModel<T, NS : EmaNavigationState> : EmaViewModel<T, NS>() {
    override fun onResume(firstTime: Boolean) {
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override fun onCleared() {
        try {
            super.onCleared()
        } catch (e: Exception) {
        }
    }
}