package es.babel.easymvvm.presentation.dialog.totalGames

import es.babel.easymvvm.core.dialog.EmaDialogListener

interface TotalGamesDialogListener : EmaDialogListener {
    fun onCancelClicked()
    fun onConfirmClicked()
}