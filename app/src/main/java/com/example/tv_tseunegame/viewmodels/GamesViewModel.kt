package com.example.tv_tseunegame.viewmodels

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tv_tseunegame.BasicApp
import com.example.tv_tseunegame.data.local.entities.GameEntity
import com.example.tv_tseunegame.data.repositories.GameRepository

class GamesViewModel(private val gameRepository: GameRepository) : ViewModel() {

    private var mObservableGames: LiveData<List<GameEntity>> = gameRepository.getGames()

    /**
     * Expose the product to allow the UI to observe it
     */
    fun getGames(): LiveData<List<GameEntity>> {
        return mObservableGames
    }

    /**
     * Factory is used to inject dynamically all dependency to the viewModel like reposiroty, or id
     * or whatever
     */
    class Factory(private val mApplication: Application) :
        ViewModelProvider.NewInstanceFactory() {

        private val mRepository: GameRepository = (mApplication as BasicApp).getCatRepository()

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return GamesViewModel(mRepository) as T
        }
    }

}