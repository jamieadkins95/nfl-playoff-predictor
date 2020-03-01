package com.jamieadkins.nfl.predictor.predictions

import android.view.View
import coil.api.load
import com.jamieadkins.nfl.predictor.R
import com.jamieadkins.nfl.predictor.domain.MatchEntity
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.view_match.view.*

data class PredictionItem(
    val match: MatchEntity
) : Item(match.id) {

    override fun getLayout(): Int = R.layout.view_match

    override fun bind(viewHolder: GroupieViewHolder, position: Int)  = viewHolder.itemView.bind()

    private fun View.bind() {
        homeTeamLogo.load(match.homeTeam.logoUrl)
        awayTeamLogo.load(match.awayTeam.logoUrl)
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int = 1
}