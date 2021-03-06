package es.babel.easymvvm.android.viewmodel

import es.babel.easymvvm.android.extra.EmaReceiverModel
import es.babel.easymvvm.android.extra.EmaResultModel
import es.babel.easymvvm.android.ui.EmaResultViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaExtraData
import es.babel.easymvvm.core.state.EmaState
import java.io.Serializable

/**
 * View model to handle view states.
 *
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
abstract class EmaViewModel<S, NS : EmaNavigationState> : EmaBaseViewModel<EmaState<S>, NS>() {

    /**
     * State of the view
     */
    private var viewState: S? = null

    internal lateinit var resultViewModel: EmaResultViewModel

    override fun onStart(inputState: EmaState<S>?): Boolean {
        if (viewState == null)
            inputState?.let { viewState = it.data }
        onResultListenerSetup()
        return super.onStart(inputState)
    }

    /**
     * Here should implement the listener for result data from other views through [addOnResultReceived] method
     */
    protected open fun onResultListenerSetup() {
        //Calls to [addOnResultReceived] if they are needed
    }

    /**
     * Update the data of the state without notifying it to the view.
     */
    private fun updateData(newState: S): EmaState<S> {
        return when (state) {
            is EmaState.Error -> {
                val errorState = state as EmaState.Error
                EmaState.Error(newState, errorState.error)
            }
            is EmaState.Normal -> {
                EmaState.Normal(newState)
            }

            is EmaState.Alternative -> {
                val alternativeState = state as EmaState.Alternative
                EmaState.Alternative(newState, alternativeState.dataAlternative)
            }
            null -> EmaState.Normal(newState)
        }
    }

    /**
     * Update the current state and update the normal view state by default
     * @param changeStateFunction create the new state
     */
    protected open fun updateToNormalState(changeStateFunction: S.() -> S) {
        viewState?.let {
            viewState = changeStateFunction.invoke(it)
            viewState?.let { newState -> state = EmaState.Normal(newState) }
            updateToNormalState()
        }

    }

    /**
     * Update the data of current state without notify it to the view.
     * @param changeStateFunction create the new state
     */
    protected fun updateDataState(changeStateFunction: S.() -> S) {
        viewState?.let {
            viewState = changeStateFunction.invoke(it)
            viewState?.let { newState -> state = updateData(newState) }
        }
    }

    /**
     * Used for trigger an update on the view
     * Use the EmaState -> Normal
     */
    protected open fun updateToNormalState() {
        state?.let {
            viewState?.let { currentState ->
                super.updateView(EmaState.Normal(currentState))
            }
        }
    }

    /**
     * Check the current view state
     * @param checkStateFunction function to check the current state
     * @return the value returned by [checkStateFunction]
     */
    fun <T> checkDataState(checkStateFunction: (S) -> T): T {
        return viewState?.let {
            checkStateFunction.invoke(it)
        } ?: let {
            val initialState = initialViewState
            viewState = initialState
            checkStateFunction.invoke(initialState)
        }
    }

    /**
     * Used for trigger an error on the view
     * Use the EmaState -> Error
     * @param error generated
     */
    protected open fun updateToErrorState(error: Throwable) {
        viewState?.let {
            super.updateView(EmaState.Error(it, error))
        } ?: throwInitialStateException()

    }

    /**
     * Used for trigger a updateToAlternativeState event on the view
     * Use the EmaState -> Alternative
     * @param data with updateToAlternativeState information
     */
    protected open fun updateToAlternativeState(data: EmaExtraData? = null) {
        viewState?.let { state ->
            val alternativeData: EmaState.Alternative<S> = data?.let {
                EmaState.Alternative(state, dataAlternative = it)
            } ?: EmaState.Alternative(state)

            super.updateView(alternativeData)
        } ?: throwInitialStateException()

    }

    /**
     * Generate the initial state with EmaState to trigger normal/updateToAlternativeState/error states
     * for the view.
     */
    final override fun createInitialState(): EmaState<S> {
        if (viewState == null) {
            viewState = initialViewState
        }

        return EmaState.Normal(viewState!!)
    }

    /**
     * Throws exception if the state of the view has not been initialized
     */
    private fun throwInitialStateException(): Nothing =
            throw RuntimeException("Initial state has not been created")

    /**
     * Generate the initial state of the view
     */
    abstract val initialViewState: S

    /**
     * Set a result for previous view when the current one is destroyed
     */
    protected fun addResult(data: Serializable, code: Int = EmaResultViewModel.RESULT_ID_DEFAULT) {
        resultViewModel.addResult(
                EmaResultModel(
                        id = code,
                        ownerId = getId(),
                        data = data))
    }

    /**
     * Set the listener for back data when the result view is destroyed
     */
    protected fun addOnResultReceived(code: Int = EmaResultViewModel.RESULT_ID_DEFAULT, receiver: (EmaResultModel) -> Unit) {
        val emaReceiver = EmaReceiverModel(
                ownerCode = getId(),
                resultId = code,
                function = receiver
        )
        resultViewModel.addResultReceiver(emaReceiver)
    }

    override fun onCleared() {
        super.onCleared()
        resultViewModel.notifyResults(getId())
    }

    private fun getId(): Int {
        return this.javaClass.name.hashCode()
    }
}