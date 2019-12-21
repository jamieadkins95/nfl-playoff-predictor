package com.jamieadkins.nfl.predictor.domain

sealed class MatchOutcomeEntity {

    object HomeTeamWin : MatchOutcomeEntity()
    object AwayTeamWin : MatchOutcomeEntity()
    object Tie : MatchOutcomeEntity()
    object Undecided : MatchOutcomeEntity()
}