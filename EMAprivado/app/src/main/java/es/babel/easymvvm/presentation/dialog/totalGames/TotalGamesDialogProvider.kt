package es.babel.easymvvm.presentation.dialog.totalGames

import androidx.fragment.app.FragmentManager
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialogProvider

class TotalGamesDialogProvider constructor(fragmentManager: FragmentManager) : EmaBaseDialogProvider(fragmentManager) {
    override fun generateDialog(): EmaBaseDialog<*> = TotalGamesDialog()
}