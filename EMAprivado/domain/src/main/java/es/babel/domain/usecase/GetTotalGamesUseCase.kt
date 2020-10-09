package es.babel.domain.usecase

import es.babel.domain.model.TotalGamesDataModel
import es.babel.domain.repository.Repository
import es.babel.easymvvm.core.usecase.EmaUseCase

class GetTotalGamesUseCase(private val repository: Repository) : EmaUseCase<Unit, TotalGamesDataModel>() {
    override suspend fun useCaseFunction(input: Unit): TotalGamesDataModel {
        return repository.getTotalGames()
    }
}