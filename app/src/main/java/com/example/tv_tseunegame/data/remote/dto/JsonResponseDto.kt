package com.example.tv_tseunegame.data.remote.dto

import com.example.tv_tseunegame.data.local.entities.GameEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonResponseDto(@Json(name = "next")
                        val next: String? = "",
                           @Json(name = "previous")
                        val previous: String? = "",
                           @Json(name = "count")
                        val count: Int = 0,
                           @Json(name = "results")
                        val results: List<GameDto>?)
{
    fun toGames() : List<GameEntity>{
        return results!!.map { it.toEntity() }
    }
}