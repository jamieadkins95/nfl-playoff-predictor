package com.jamieadkins.nfl.predictor.domain

import io.reactivex.Observable

interface PredictionsRepository {

    fun getPredictionsForSeason(season: Int): Observable<Map<Long, MatchOutcomeEntity>>
}