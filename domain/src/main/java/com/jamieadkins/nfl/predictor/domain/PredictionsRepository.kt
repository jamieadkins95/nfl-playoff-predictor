package com.jamieadkins.nfl.predictor.domain

import io.reactivex.Completable
import io.reactivex.Observable

interface PredictionsRepository {

    fun getPredictionsForSeason(season: Int): Observable<Map<String, MatchOutcomeEntity>>

    fun savePrediction(matchId: String, season: Int, outcomeEntity: MatchOutcomeEntity): Completable
}