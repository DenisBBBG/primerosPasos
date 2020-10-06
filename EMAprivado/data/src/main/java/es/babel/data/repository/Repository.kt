package es.babel.data.repository

import es.babel.data.model.CoverResponse
import es.babel.data.model.toDomainModel
import es.babel.data.net.Api
import es.babel.data.net.ServiceBuilder
import es.babel.domain.model.CoverListModel
import es.babel.domain.model.GameModel
import es.babel.domain.repository.Repository


/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Created by: Carlos Mateo Benito on 19/1/19.
 */
class Repository : Repository {

    private val api: Api =
            ServiceBuilder.getServiceBuilder().create(Api::class.java)

    companion object {
        const val COMPLETE_URL = "https:"
    }

    override suspend fun getGames() = api.getGames().map { item ->

        GameModel(
                title = item.name,
                cover = item.cover?.let { id ->
                    getURLCover(id).firstOrNull()?.let { item ->
                        COMPLETE_URL + item.url
                    }
                },
                summary = item.summary,
                checksum = item.checksum,
                url = item.url
        )
    }

    override suspend fun getURLCover(id: Long): CoverListModel {
        return api.getURLCover(id).toDomainModel()
    }
}
