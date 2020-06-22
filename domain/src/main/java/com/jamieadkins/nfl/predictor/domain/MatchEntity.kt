package com.jamieadkins.nfl.predictor.domain

data class MatchEntity(
    val id: String,
    val homeTeam: TeamEntity,
    val awayTeam: TeamEntity,
    val outcome: MatchOutcomeEntity
)