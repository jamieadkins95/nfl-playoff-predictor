package com.jamieadkins.nfl.predictor.predictions

import com.jamieadkins.nfl.predictor.domain.PredictionState

interface PredictionsContract {

    interface View {
        fun showLoadingIndicator()
        fun hideLoadingIndicator()
        fun showPredictions(predictions: PredictionState)
    }
}