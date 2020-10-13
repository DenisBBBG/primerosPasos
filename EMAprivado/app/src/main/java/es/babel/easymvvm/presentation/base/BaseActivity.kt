package es.babel.easymvvm.presentation.base

import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.EmaToolbarFragmentActivity
import es.babel.easymvvm.presentation.injection.activityInjection
import org.kodein.di.Kodein

abstract class BaseActivity : EmaToolbarFragmentActivity() {
    override val overrideTheme: Boolean = true

    override fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module = activityInjection(this)

    override val layoutId = R.layout.activity_base

}