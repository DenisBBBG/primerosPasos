package es.babel.easymvvm.presentation.dialog.totalGames

import es.babel.easymvvm.core.dialog.EmaDialogData

data class TotalGamesDialogData(
        val title: String = "",
        val message: String = "",
        val info: String = "",
        val accept: String = "",
        val cancel: String = "",
        override val proportionWidth: Float? = 7 / 10f,
        override val proportionHeight: Float? = null) : EmaDialogData
