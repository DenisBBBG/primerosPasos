package es.babel.easymvvm.presentation.dialog.loading

import android.view.View
import es.babel.easymvvm.R
import es.babel.easymvvm.android.ui.dialog.EmaBaseDialog
import kotlinx.android.synthetic.main.dialog_loading.view.*

/**
 * Simple dialog
 *
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
class LoadingDialog : EmaBaseDialog<LoadingDialogData>() {

    override val layoutId: Int = R.layout.dialog_loading

    //Al inicializar el dialogo se carga esta funcion
    override fun setupData(data: LoadingDialogData, view: View) {
        view.tvDialogLoadingTitle.text = data.title

        isCancelable = false
    }
}