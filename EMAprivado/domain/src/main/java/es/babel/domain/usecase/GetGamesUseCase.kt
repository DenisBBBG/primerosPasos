package es.babel.domain.usecase

import es.babel.domain.model.GameModelList
import es.babel.domain.repository.Repository
import es.babel.easymvvm.core.usecase.EmaUseCase

/**
 * Login
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

class GetGamesUseCase(private val repository: Repository) : EmaUseCase<Unit, GameModelList>() {
    override suspend fun useCaseFunction(input: Unit): GameModelList {
        return repository.getGames()
    }
}