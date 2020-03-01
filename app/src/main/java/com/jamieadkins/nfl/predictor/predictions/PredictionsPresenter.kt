package com.jamieadkins.nfl.predictor.predictions

import com.jamieadkins.nfl.predictor.domain.GameWeekEntity
import com.jamieadkins.nfl.predictor.domain.MatchEntity
import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.jamieadkins.nfl.predictor.domain.PredictionState
import com.jamieadkins.nfl.predictor.domain.TeamEntity
import javax.inject.Inject

class PredictionsPresenter @Inject constructor() : PredictionsContract.Presenter {

    var view: PredictionsContract.View? = null

    override fun onAttach(newView: PredictionsContract.View) {
        view = newView
        val saints = TeamEntity(
            1, "Saints", "NO", "https://upload.wikimedia.org/wikipedia/en/7/72/Arizona_Cardinals_logo.svg"
        )

        val arizona = TeamEntity(
            2, "Cardinals", "ARI", "https://upload.wikimedia.org/wikipedia/en/7/72/Arizona_Cardinals_logo.svg"
        )
        val match = MatchEntity(1, arizona, saints, MatchOutcomeEntity.HomeTeamWin)
        val mockPredictions = PredictionState(
            2019,
            listOf(
                GameWeekEntity(
                    listOf(match, match, match, match, match, match, match, match, match, match)
                )
            )
        )
        view?.showPredictions(mockPredictions)
    }

    override fun onDetach() {
        view = null
    }

    override fun makePrediction(matchId: Long, teamId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}