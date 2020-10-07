package es.babel.easymvvm.presentation.ui.list

import es.babel.domain.model.GameModel
import es.babel.easymvvm.core.state.EmaBaseState

data class GamesListState(
        var gameList: List<GameModel>? = null
) : EmaBaseState