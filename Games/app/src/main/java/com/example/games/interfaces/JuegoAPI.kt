package com.example.games.interfaces

import com.example.games.JuegosItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JuegoAPI {
    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/games/?fields=*")
    fun getGames(): Call<List<JuegosItem>>

}