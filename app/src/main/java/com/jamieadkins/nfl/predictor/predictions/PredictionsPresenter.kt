package com.jamieadkins.nfl.predictor.predictions

import com.jamieadkins.nfl.predictor.domain.GetPredictionsForSeasonUseCase
import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.jamieadkins.nfl.predictor.domain.SavePredictionUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

class PredictionsPresenter @Inject constructor(
    private val getPredictionsForSeasonUseCase: GetPredictionsForSeasonUseCase,
    private val savePredictionUseCase: SavePredictionUseCase
) : PredictionsContract.Presenter {

    var view: PredictionsContract.View? = null

    private val season = 2019

    override fun onAttach(newView: PredictionsContract.View) {
        view = newView

        getPredictionsForSeasonUseCase.getSeason(season)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.showPredictions(it)
            }
    }

    override fun onDetach() {
        view = null
    }

    override fun makePrediction(matchId: String, outcome: MatchOutcomeEntity) {
        savePredictionUseCase(matchId, season, outcome).subscribeOn(Schedulers.io()).onErrorComplete().subscribe()
    }
}