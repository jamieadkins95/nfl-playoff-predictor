package com.jamieadkins.nfl.predictor.predictions

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
abstract class PredictionsModule {

    @Binds
    @FragmentScoped
    abstract fun presenter(presenter: PredictionsPresenter): PredictionsContract.Presenter

}
