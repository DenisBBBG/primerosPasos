package es.babel.easymvvm.presentation.dialog.simpleTotalGames

import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialog

class SimpleTotalGamesDialogProvider constructor(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager) {
    override fun generateDialog(): EmaBaseDialog<*> = SimpleDialog()
}