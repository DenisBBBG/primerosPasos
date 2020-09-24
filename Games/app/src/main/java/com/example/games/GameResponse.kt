package com.example.games

import com.google.gson.annotations.SerializedName

typealias GameResponse = List<GameResponseItem>

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

