package es.babel.easymvvm.presentation.dialog.totalGames

import android.view.View
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import kotlinx.android.synthetic.main.dialog_total_games.view.*

class TotalGamesDialog() : EmaBaseDialog<TotalGamesDialogData>() {
    override val layoutId: Int = es.babel.easymvvm.R.layout.dialog_total_games

    override fun setupData(data: TotalGamesDialogData, view: View) {
        with(data) {
            (dialogListener as? TotalGamesDialogListener)?.let { listener ->
                view.btnTotalGamesDialogNo.setOnClickListener { listener.onCancelClicked() }
                view.btnTotalGamesDialogYes.setOnClickListener { listener.onConfirmClicked() }
            }

            view.tvTotalGamesDialogTitle!!.text = title

            view.tvTotalGamesDialogMessage!!.text = message

            view.tvTotalGamesDialogInfo!!.text = info

            view.btnTotalGamesDialogYes.text = accept

            if (cancel.isEmpty()) {
                view.btnTotalGamesDialogNo.visibility = View.GONE
            }

            view.btnTotalGamesDialogNo.text = cancel

            isCancelable = false
        }
    }
}