package com.jamieadkins.nfl.predictor.data.predictions

import com.jamieadkins.nfl.predictor.domain.MatchOutcomeEntity
import com.jamieadkins.nfl.predictor.domain.PredictionsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class PredictionsRepositoryImpl @Inject constructor(
    private val predictionsDao: PredictionsDao
) : PredictionsRepository {

    override fun getPredictionsForSeason(season: Int): Observable<Map<String, MatchOutcomeEntity>> {
        return predictionsDao.getPredictions(season)
            .map { predictions ->
                predictions.map { prediction -> prediction.matchId to mapOutcome(prediction.outcome) }.toMap()
            }
    }

    override fun savePrediction(matchId: String, season: Int, outcomeEntity: MatchOutcomeEntity): Completable {
        return predictionsDao.insert(Prediction(matchId, season, mapOutcome(outcomeEntity)))
    }

    private fun mapOutcome(from: String): MatchOutcomeEntity {
        return when (from) {
            "home" -> MatchOutcomeEntity.HomeTeamWin
            "away" -> MatchOutcomeEntity.AwayTeamWin
            "tie" -> MatchOutcomeEntity.Tie
            else -> MatchOutcomeEntity.Undecided
        }
    }

    private fun mapOutcome(from: MatchOutcomeEntity): String {
        return when (from) {
            MatchOutcomeEntity.HomeTeamWin -> "home"
            MatchOutcomeEntity.AwayTeamWin -> "away"
            MatchOutcomeEntity.Tie -> "tie"
            MatchOutcomeEntity.Undecided -> "undecided"
        }
    }
}