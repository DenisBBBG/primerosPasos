package com.example.games

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JuegoAPI {

    @GET("/games")
    fun getGames(@Query("fields") fields: String): Call<Juego>

}