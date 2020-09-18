package com.example.games

class Juego : ArrayList<JuegosItem>()

data class JuegosItem (
    val name: String,
    val cover: Int?
)

data class CoverItem (
    val url: String
)
