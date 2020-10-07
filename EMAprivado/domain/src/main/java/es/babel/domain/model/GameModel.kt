package es.babel.domain.model

import java.io.Serializable

typealias GameModelList = List<GameModel>

data class GameModel(
        val title: String?,
        val cover: String?,
        val summary: String?,
        val url: String?,
        val checksum: String?
) : Serializable
