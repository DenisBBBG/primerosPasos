package es.babel.data.net


import es.babel.data.model.CoverResponse
import es.babel.data.model.GameResponse
import retrofit2.http.*

interface Api {
    @GET("/games/?fields=cover,name,summary,url,checksum&limit=10")
    suspend fun getGames(): GameResponse

    @GET("/covers/{id}/?fields=url")
    suspend fun getURLCover(@Path("id") id: Long): CoverResponse

}