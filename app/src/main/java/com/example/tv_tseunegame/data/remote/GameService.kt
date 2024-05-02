package com.example.tv_tseunegame.data.remote

import androidx.lifecycle.LiveData
import com.example.tv_tseunegame.data.remote.dto.GameDto
import com.example.tv_tseunegame.data.remote.dto.JsonResponseDto
import com.github.leonardoxh.livedatacalladapter.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {

    @GET("games")
    fun getAllGames(@Query("key") key : String) : LiveData<Resource<JsonResponseDto>>

}