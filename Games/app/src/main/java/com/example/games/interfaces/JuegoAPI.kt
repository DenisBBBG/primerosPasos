package com.example.games.interfaces

import com.example.games.CoverResponse
import com.example.games.GameResponse
import retrofit2.http.*

interface JuegoAPI {
    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=10")
    suspend fun getGames(): GameResponse


    @Headers("user-key: f5a3a47ff1d75c223eddb66ffa1e31e6")
    @GET("/covers/{id}/?fields=url")
    suspend fun getURLCover(@Path("id") id: Long): CoverResponse

}