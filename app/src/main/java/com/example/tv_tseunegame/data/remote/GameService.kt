package com.example.tv_tseunegame.data.remote

import androidx.lifecycle.LiveData
import com.example.tv_tseunegame.data.remote.dto.GameDto
import com.github.leonardoxh.livedatacalladapter.Resource
import retrofit2.http.GET

interface GameService {

    @GET("games")
    fun getAllGames() : LiveData<Resource<List<GameDto>>>

}