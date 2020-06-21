package com.jamieadkins.nfl.predictor.predictions

import com.jamieadkins.nfl.predictor.domain.GetPredictionsForSeasonUseCase
import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import kotlin.random.Random

class PredictionsPresenter @Inject constructor(
    private val getPredictionsForSeasonUseCase: GetPredictionsForSeasonUseCase
) : PredictionsContract.Presenter {

    var view: PredictionsContract.View? = null

    override fun onAttach(newView: PredictionsContract.View) {
        view = newView

        getPredictionsForSeasonUseCase.getSeason(2019)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view?.showPredictions(it)
            }
    }

    override fun onDetach() {
        view = null
    }

    override fun makePrediction(matchId: Long, teamId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}