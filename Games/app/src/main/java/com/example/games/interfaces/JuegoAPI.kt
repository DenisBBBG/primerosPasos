package com.example.games.interfaces

import com.example.games.CoverResponse
import com.example.games.GameResponse
import retrofit2.http.*

interface JuegoAPI {
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=10")
    suspend fun getGames(): GameResponse

    @GET("/covers/{id}/?fields=url")
    suspend fun getURLCover(@Path("id") id: Long): CoverResponse

}