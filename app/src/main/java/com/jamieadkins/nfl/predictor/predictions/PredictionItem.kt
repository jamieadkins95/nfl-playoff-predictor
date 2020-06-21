package com.jamieadkins.nfl.predictor.predictions

import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import coil.api.load
import com.jamieadkins.nfl.predictor.R
import com.jamieadkins.nfl.predictor.domain.MatchEntity
import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.view_match.view.*

data class PredictionItem(
    val match: MatchEntity
) : Item(match.id) {

    override fun getLayout(): Int = R.layout.view_match

    override fun bind(viewHolder: GroupieViewHolder, position: Int) = viewHolder.itemView.bind()

    private fun View.bind() {
        homeTeamLogo.load(match.homeTeam.logoUrl)
        awayTeamLogo.load(match.awayTeam.logoUrl)
        away.text = match.awayTeam.abbreviation
        home.text = match.homeTeam.abbreviation

        when (match.outcome) {
            is MatchOutcomeEntity.HomeTeamWin -> results.check(R.id.home)
            is MatchOutcomeEntity.AwayTeamWin -> results.check(R.id.away)
            is MatchOutcomeEntity.Tie -> results.check(R.id.tie)
            is MatchOutcomeEntity.Undecided -> results.clearCheck()
        }
    }

    override fun getSpanSize(spanCount: Int, position: Int): Int = 1
}