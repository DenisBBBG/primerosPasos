package com.example.games.interfaces

import com.example.games.CoverItem
import com.example.games.JuegosItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface JuegoAPI {
    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=50")
    fun getGames(): Call<List<JuegosItem>>

    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/covers/{id}/?fields=url")
    fun getURLCover(@Path("id") id: Int?): Call<List<CoverItem>>

}