package com.jamieadkins.nfl.predictor.domain

data class MatchEntity(
    val id: Long,
    val homeTeam: TeamEntity,
    val awayTeam: TeamEntity,
    val outcome: MatchOutcomeEntity
)