package com.example.tv_tseunegame.data.remote.dto

import com.example.tv_tseunegame.data.local.entities.GameEntity
import com.example.tv_tseunegame.data.local.entities.GenreEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreDto(@Json(name = "games_count")
                    val gamesCount: Int = 0,
                    @Json(name = "name")
                    val name: String = "",
                    @Json(name = "id")
                    val id: Int = 0,
                    @Json(name = "image_background")
                    val imageBackground: String? = "",
                    @Json(name = "slug")
                    val slug: String = "")
{
    fun toEntity(): GenreEntity {
            return GenreEntity(
                name,
                id,
                imageBackground,
                slug
            )
    }
}