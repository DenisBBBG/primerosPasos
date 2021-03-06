package es.babel.data.model

import com.google.gson.annotations.SerializedName

typealias GameResponse = List<GameResponseItem>

/*
fun GameResponse.toDomainModel() = this.map {
    it.toDomainModel()
}
*/

data class GameResponseItem(
        @SerializedName("id")
        val id: Long,
        @SerializedName("cover")
        val cover: Long? = null,
        @SerializedName("name")
        val name: String,
        @SerializedName("summary")
        val summary: String? = null,
        @SerializedName("url")
        val url: String,
        @SerializedName("checksum")
        val checksum: String
)

/*
fun GameResponseItem.toDomainModel() = GameModel(
        title = name,
        cover = cover,
        summary = summary,
        url = url,
        checksum = checksum

)
*/
