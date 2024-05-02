/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.example.tv_tseunegame.ui

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.tv_tseunegame.R
import com.example.tv_tseunegame.ui.presenter.GameItemView
import com.example.tv_tseunegame.ui.presenter.GamePresenter
import com.example.tv_tseunegame.viewmodels.GamesViewModel


/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : BrowseSupportFragment() {

    private lateinit var viewModel: GamesViewModel
    private val windowAdapter = ArrayObjectAdapter(ListRowPresenter())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        init()

        setUI()

        subscribeToModel(viewModel)

    }

    private fun init(){
        //Inject dependance dynamically
        val factory = GamesViewModel.Factory(requireActivity().application)
        viewModel = ViewModelProviders.of(this, factory).get(GamesViewModel::class.java)
    }

    private fun setUI(){
        title = "Tseunegame TV"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = ContextCompat.getColor(requireContext(),
            R.color.primary_darker
        )
        searchAffordanceColor = ContextCompat.getColor(requireContext(),
            R.color.primary_lighter
        )

    }

    private fun subscribeToModel(gamesViewModel: GamesViewModel) {

        gamesViewModel.getGames().observe(viewLifecycleOwner, Observer { games ->
            val menuAdapter =  ArrayObjectAdapter(GamePresenter(requireContext()))
            val menuCategorie = HeaderItem(0, "Jeux")

            games.forEach { game ->
                menuAdapter.add(GameItemView(game.name, game.backgroundImage, game.rate))
            }

            windowAdapter.add(ListRow(menuCategorie, menuAdapter))

            adapter = windowAdapter

        })

    }





}
