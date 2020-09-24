package com.example.games.interfaces

import com.example.games.CoverResponse
import com.example.games.GameResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface JuegoAPI {
    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
<<<<<<< Updated upstream
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=10")
   suspend fun getGames(): GameResponse
   
=======
    @GET("/games/?fields=cover,name&limit=10")
    fun getGames(): Call<List<JuegosItem>>
>>>>>>> Stashed changes

    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/covers/{id}/?fields=url")
   suspend fun getURLCover(@Path("id") id: Long): CoverResponse

}