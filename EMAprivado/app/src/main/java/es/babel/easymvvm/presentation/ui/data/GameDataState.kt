package es.babel.easymvvm.presentation.ui.data

import es.babel.domain.model.GameModel
import es.babel.easymvvm.core.state.EmaBaseState

data class GameDataState(
        var game: GameModel? = null
) : EmaBaseState