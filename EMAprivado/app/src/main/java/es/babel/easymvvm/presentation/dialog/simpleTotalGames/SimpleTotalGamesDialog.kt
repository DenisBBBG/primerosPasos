package es.babel.easymvvm.presentation.dialog.simpleTotalGames

import android.view.View
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogData
import es.babel.easymvvm.presentation.dialog.simple.SimpleDialogListener
import kotlinx.android.synthetic.main.dialog_simple.view.*

class SimpleTotalGamesDialog() : EmaBaseDialog<SimpleDialogData>() {
    override val layoutId: Int = es.babel.easymvvm.R.layout.dialog_simple_total_games

    override fun setupData(data: SimpleDialogData, view: View) {
        with(data) {
            (dialogListener as? SimpleDialogListener)?.let { listener ->
                view.bDialogSimpleNo.setOnClickListener { listener.onCancelClicked() }
                view.ivDialogSimpleCross.setOnClickListener { listener.onCancelClicked() }
                view.bDialogSimpleYes.setOnClickListener { listener.onConfirmClicked() }
            }

            view.tvDialogSimpleTitle!!.text = title

            if (showCross)
                view.ivDialogSimpleCross.visibility = if (showCross) View.VISIBLE else View.GONE

            view.tvDialogSimpleMessage!!.text = message

            view.bDialogSimpleYes.text = accept

            view.ivDialogSimple.visibility =
                    image?.let {
                        view.ivDialogSimple.setImageDrawable(it)
                        View.VISIBLE
                    } ?: View.GONE

            if (cancel.isEmpty()) {
                view.bDialogSimpleNo.visibility = View.GONE
            }

            view.bDialogSimpleNo.text = cancel

            isCancelable = false
        }
    }
}