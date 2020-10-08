package es.babel.easymvvm.presentation.dialog.simpleTotalGames

import android.view.View
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogListener
import kotlinx.android.synthetic.main.dialog_simple.view.*
import kotlinx.android.synthetic.main.dialog_simple_total_games.view.*

class SimpleTotalGamesDialog() : EmaBaseDialog<SimpleTotalGamesDialogData>() {
    override val layoutId: Int = es.babel.easymvvm.R.layout.dialog_simple_total_games

    override fun setupData(data: SimpleTotalGamesDialogData, view: View) {
        with(data) {
            (dialogListener as? SimpleDialogListener)?.let { listener ->
                view.bDialogSimpleNo.setOnClickListener { listener.onCancelClicked() }
                view.ivDialogSimpleCross.setOnClickListener { listener.onCancelClicked() }
                view.bDialogSimpleYes.setOnClickListener { listener.onConfirmClicked() }
            }

            view.tvSimpleTotalGamesDialogTitle!!.text = title

            view.tvSimpleTotalGamesDialogMessage!!.text = message

            view.tvSimpleTotalGamesDialogInfo!!.text = info

            view.btnSimpleTotalGamesDialogYes.text = accept

            if (cancel.isEmpty()) {
                view.btnSimpleTotalGamesDialogNo.visibility = View.GONE
            }

            view.btnSimpleTotalGamesDialogNo.text = cancel

            isCancelable = false
        }
    }
}