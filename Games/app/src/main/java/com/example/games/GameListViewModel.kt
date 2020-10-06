package com.example.games


import com.example.games.interfaces.JuegoAPI

class GameListViewModel {

    companion object{
        const val COMPLETE_URL = "https:"
    }

    private val userService: JuegoAPI =
        ServiceBuilder.getServiceBuilder().create(JuegoAPI::class.java)

    suspend fun getGames() = userService.getGames().map { item ->
        GameModel(
            title = item.name,
            cover = item.cover?.let { id ->
                userService.getURLCover(id).firstOrNull()?.let { item ->
                    COMPLETE_URL + item.url
                }
            },
            summary = item.summary,
            checksum = item.checksum,
            url = item.url

        )
    }


}