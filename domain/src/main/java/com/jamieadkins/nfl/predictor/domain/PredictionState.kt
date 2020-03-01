package com.jamieadkins.nfl.predictor.domain

data class PredictionState(
    val season: Int,
    val gameweeks: List<GameWeekEntity>
)
