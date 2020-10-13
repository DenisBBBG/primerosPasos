package es.babel.domain.repository

import es.babel.domain.model.CoverListModel
import es.babel.domain.model.GameModelList
import es.babel.domain.model.TotalGamesDataModel

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

interface Repository {

    suspend fun getGames(): GameModelList

    suspend fun getURLCover(id: Long): CoverListModel

    suspend fun getTotalGames(): TotalGamesDataModel
}