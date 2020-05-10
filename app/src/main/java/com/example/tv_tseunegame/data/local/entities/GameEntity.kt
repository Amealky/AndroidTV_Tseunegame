package com.example.tv_tseunegame.data.local.entities


class GameEntity (
    val name: String = "",
    val rate: Double = 0.0,
    val playtime: Int = 0,
    val backgroundImage: String = "",
    val themeColor: String = "",
    val released_date: String = "",
    val platforms: List<PlatformEntity>,
    val genres: List<GenreEntity>){

}