package com.example.games

class Juego : ArrayList<JuegosItem>()

data class JuegosItem (
    val name: String,
    val cover: Int?,
    val summary: String,
    val url: String,
    val checksum: String
)

data class CoverItem (
    val url: String
)
