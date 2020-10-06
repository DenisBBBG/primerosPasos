package es.babel.data.model

import com.google.gson.annotations.SerializedName
import es.babel.domain.model.CoverModel

typealias CoverResponse = List<CoverResponseItem>

fun CoverResponse.toDomainModel() = this.map {
    it.toDomainModel()
}

data class CoverResponseItem(
        @SerializedName("id")
        val id: Long,
        @SerializedName("url")
        val url: String
)

fun CoverResponseItem.toDomainModel() = CoverModel(
        id = id,
        url = url
)