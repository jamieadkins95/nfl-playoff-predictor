package com.jamieadkins.nfl.predictor.domain

data class PredictionState(
    val season: Int,
    val matches: List<GameWeekEntity>
)
