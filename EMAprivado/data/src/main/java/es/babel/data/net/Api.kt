package es.babel.data.net

import es.babel.data.model.CoverResponse
import es.babel.data.model.GameResponse
import es.babel.data.model.TotalGamesResponse
import es.babel.domain.model.TotalGamesDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=10")
    suspend fun getGames(): GameResponse

    @GET("/covers/{id}/?fields=url")
    suspend fun getURLCover(@Path("id") id: Long): CoverResponse

    @GET("/games/count")
    suspend fun getTotalGames(): TotalGamesResponse
}