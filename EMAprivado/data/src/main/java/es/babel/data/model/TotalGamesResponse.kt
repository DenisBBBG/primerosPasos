package es.babel.data.model

import com.google.gson.annotations.SerializedName
import es.babel.domain.model.TotalGamesDataModel
import java.io.Serializable

data class TotalGamesResponse(
        @SerializedName("count")
        val count: Long
) : Serializable

fun TotalGamesResponse.toDomainModel() = TotalGamesDataModel(
        count = count
)