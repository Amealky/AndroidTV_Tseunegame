package com.example.tv_tseunegame

import android.app.Application
import com.example.tv_tseunegame.data.remote.NetworkProvider
import com.example.tv_tseunegame.data.repositories.GameRepository

class BasicApp: Application() {

    override fun onCreate() {
        super.onCreate()

    }


    fun getCatRepository() : GameRepository{
        return GameRepository(NetworkProvider.provideGameService())
    }

}
