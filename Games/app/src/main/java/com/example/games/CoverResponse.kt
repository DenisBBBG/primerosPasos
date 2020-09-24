package com.example.games

import com.google.gson.annotations.SerializedName


typealias CoverResponse = List<CoverResponseItem>

data class CoverResponseItem(

    @SerializedName("id")
    val id: Long,
    @SerializedName("url")
    val url: String
)