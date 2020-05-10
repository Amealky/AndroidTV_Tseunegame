package com.example.tv_tseunegame.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlatformDto(@Json(name = "platform")
                       val platform: PlatformDetailDto)