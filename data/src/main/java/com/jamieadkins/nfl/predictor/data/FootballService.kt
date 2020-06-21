package com.jamieadkins.nfl.predictor.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface FootballService {

    @GET("sports/football/nfl/scoreboard")
    fun scoreboard(@Query("limit") limit: Int, @Query("dates") dates: String): Single<ScoreboardResponse>

}