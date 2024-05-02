package com.example.tv_tseunegame.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.tv_tseunegame.BuildConfig
import com.example.tv_tseunegame.data.local.entities.GameEntity
import com.example.tv_tseunegame.data.remote.GameService

class GameRepository(private val gameService: GameService) {

    private val mObservableGames: MediatorLiveData<List<GameEntity>> = MediatorLiveData()

    private fun getGamesFromApi() : LiveData<List<GameEntity>> {

        mObservableGames.addSource(gameService.getAllGames(BuildConfig.API_KEY)) {
            mObservableGames.postValue(it.resource?.toGames())

        }

        return mObservableGames
    }

    /**
     * Get the list of games from the api or other source and get notified when the data changes.
     */
    fun getGames(): LiveData<List<GameEntity>>{
        return getGamesFromApi()
    }


}