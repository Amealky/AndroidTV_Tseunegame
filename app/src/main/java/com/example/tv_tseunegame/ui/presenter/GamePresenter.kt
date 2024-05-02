package com.example.tv_tseunegame.ui.presenter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import androidx.leanback.widget.BaseCardView
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.tv_tseunegame.R


class GamePresenter(private val context: Context) : Presenter() {

    private val CARD_WIDTH = 313
    private val CARD_HEIGHT = 176

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val icv = ImageCardView(parent?.context)
        icv.cardType = BaseCardView.CARD_TYPE_INFO_UNDER_WITH_EXTRA
        icv.infoVisibility = BaseCardView.CARD_REGION_VISIBLE_ACTIVATED

        return ViewHolder(icv)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        val gameItemView = item as GameItemView
        val icv = viewHolder?.view as ImageCardView

        icv.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT)

        Glide.with(viewHolder.view.context)
            .load(gameItemView.imageUrl)
            .centerCrop()
            .into(icv.mainImageView)


        icv.titleText = gameItemView.name
        icv.contentText = "Rate : " + gameItemView.rate
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {

    }


}

