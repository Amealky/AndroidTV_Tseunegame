package com.example.tv_tseunegame.data.remote.dto

import com.example.tv_tseunegame.data.local.entities.GenreEntity
import com.example.tv_tseunegame.data.local.entities.PlatformEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlatformDetailDto(@Json(name = "image")
                          val image: String? = null,
                             @Json(name = "games_count")
                          val gamesCount: Int? = 0,
                             @Json(name = "year_end")
                          val yearEnd: String? = null,
                             @Json(name = "year_start")
                          val yearStart: String? = null,
                             @Json(name = "name")
                          val name: String = "",
                             @Json(name = "id")
                          val id: Int = 0,
                             @Json(name = "image_background")
                          val imageBackground: String? = "",
                             @Json(name = "slug")
                          val slug: String = "")

{
    fun toEntity(): PlatformEntity {
        return PlatformEntity(
            name,
            image,
            yearStart)
    }
}