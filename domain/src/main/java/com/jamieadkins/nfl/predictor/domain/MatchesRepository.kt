package com.jamieadkins.nfl.predictor.domain

import io.reactivex.Observable

interface MatchesRepository {

    fun getMatches(season: Int): Observable<List<GameWeekEntity>>
}