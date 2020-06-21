package com.jamieadkins.nfl.predictor.data.predictions

import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.jamieadkins.nfl.predictor.domain.PredictionsRepository
import io.reactivex.Observable
import javax.inject.Inject

class PredictionsRepositoryImpl @Inject constructor() : PredictionsRepository {

    override fun getPredictionsForSeason(season: Int): Observable<Map<Long, MatchOutcomeEntity>> {
        return Observable.just(emptyMap())
    }
}