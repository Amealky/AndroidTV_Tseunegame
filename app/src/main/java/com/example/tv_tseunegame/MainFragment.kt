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

package com.example.tv_tseunegame

import android.media.Image
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.*


/**
 * Loads a grid of cards with movies to browse.
 */
class MainFragment : BrowseSupportFragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setUI()

        loadRow()
    }

    private fun setUI(){
        title = "Tseunegame TV"
        headersState = HEADERS_ENABLED
        isHeadersTransitionOnBackEnabled = true
        brandColor = ContextCompat.getColor(requireContext(), R.color.primary_darker)
        searchAffordanceColor = ContextCompat.getColor(requireContext(), R.color.primary_lighter)

    }

    private fun loadRow(){
        val menuCategorie = HeaderItem(0, "Jeux")
        val menuAdapter =  ArrayObjectAdapter(GamePresenter())

        menuAdapter.add(GameItemView("Mario bros"))
        menuAdapter.add(GameItemView("Pokemon"))

        val windowAdapter = ArrayObjectAdapter(ListRowPresenter())
        windowAdapter.add(ListRow(menuCategorie, menuAdapter))

        adapter = windowAdapter
    }

    inner class GamePresenter : Presenter() {
        override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
            val icv = ImageCardView(parent?.context)
            icv.cardType = BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA
            icv.infoVisibility = BaseCardView.CARD_REGION_VISIBLE_ACTIVATED

            return ViewHolder(icv)
        }

        override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
            val gameItemView = item as GameItemView
            val icv = viewHolder?.view as ImageCardView
            icv.mainImage = requireContext().getDrawable(R.drawable.movie)
            icv.titleText = gameItemView.name
            icv.contentText = "Description here"
        }

        override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

        }

    }




}
