package com.example.tv_tseunegame.data.remote.dto

import com.squareup.moshi.Json

data class PlatformDto(@Json(name = "platform")
                       val platform: PlatformDetailDto)