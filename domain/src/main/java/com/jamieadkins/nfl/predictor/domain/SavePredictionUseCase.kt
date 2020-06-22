package com.jamieadkins.nfl.predictor.domain

import io.reactivex.Completable
import javax.inject.Inject

class SavePredictionUseCase @Inject constructor(
    private val predictionsRepository: PredictionsRepository
) {

    operator fun invoke(matchId: String, season: Int, outcome: MatchOutcomeEntity): Completable {
        return predictionsRepository.savePrediction(matchId, season, outcome)
    }
}