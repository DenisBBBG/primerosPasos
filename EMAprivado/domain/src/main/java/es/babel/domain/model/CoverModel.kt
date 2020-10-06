package es.babel.domain.model

typealias CoverListModel = List<CoverModel>

data class CoverModel(
        val id: Long,
        val url: String
)