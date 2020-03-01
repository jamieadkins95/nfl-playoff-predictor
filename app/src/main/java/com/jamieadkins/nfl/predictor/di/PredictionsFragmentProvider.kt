package com.jamieadkins.nfl.predictor.di

import com.jamieadkins.nfl.predictor.predictions.PredictionsFragment
import com.jamieadkins.nfl.predictor.predictions.PredictionsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PredictionsFragmentProvider {

    @ContributesAndroidInjector(modules = [PredictionsModule::class])
    abstract fun predictions(): PredictionsFragment

}
