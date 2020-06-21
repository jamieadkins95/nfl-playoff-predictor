package com.jamieadkins.nfl.predictor.data.predictions

import com.jamieadkins.nfl.predictor.domain.PredictionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class PredictionsDataModule {

    @Binds
    @Singleton
    abstract fun predictionsRepository(predictionsRepositoryImpl: PredictionsRepositoryImpl): PredictionsRepository

}