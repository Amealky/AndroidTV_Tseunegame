package com.example.tv_tseunegame.data.remote.dto

import com.example.tv_tseunegame.data.local.entities.GameEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDto(@Json(name = "added")
                      val added: Int = 0,
                   @Json(name = "suggestions_count")
                      val suggestionsCount: Int = 0,
                   @Json(name = "rating")
                      val rating: Double = 0.0,
                   @Json(name = "metacritic")
                      val metacritic: Int = 0,
                   @Json(name = "playtime")
                      val playtime: Int = 0,
                   @Json(name = "background_image")
                      val backgroundImage: String = "",
                   @Json(name = "tba")
                      val tba: Boolean = false,
                   @Json(name = "dominant_color")
                      val dominantColor: String = "",
                   @Json(name = "rating_top")
                      val ratingTop: Int = 0,
                   @Json(name = "reviews_text_count")
                      val reviewsTextCount: Int = 0,
                   @Json(name = "name")
                      val name: String = "",
                   @Json(name = "saturated_color")
                      val saturatedColor: String = "",
                   @Json(name = "id")
                      val id: Int = 0,
                   @Json(name = "ratings_count")
                      val ratingsCount: Int = 0,
                   @Json(name = "slug")
                      val slug: String = "",
                   @Json(name = "released")
                      val released: String = "",
                   @Json(name = "reviews_count")
                      val reviewsCount: Int = 0,
                    @Json(name= "platforms")
                        val platforms: List<PlatformDto>,
                    @Json(name= "genres")
                        val genres: List<GenreDto>)
{
    fun toEntity(): GameEntity {
        val platformsEntity = platforms.map { it.platform.toEntity() }
        val genresEntity = genres.map { it.toEntity() }

        return GameEntity(
            name,
            rating,
            playtime,
            backgroundImage,
            dominantColor,
            released,
            platformsEntity,
            genresEntity)

    }
}