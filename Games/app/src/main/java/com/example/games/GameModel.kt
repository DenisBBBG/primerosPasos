package com.example.games

import java.io.Serializable

data class GameModel(
    val title: String?,
    val cover: String?,
    val summary: String?,
    val url: String?,
    val checksum: String?
) : Serializable
