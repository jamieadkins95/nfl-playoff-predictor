package com.jamieadkins.nfl.predictor.data.predictions

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
class PredictionsDbModule {

    @Provides
    @Reusable
    fun predictionsDao(@ApplicationContext context: Context): PredictionsDao = PredictionsDatabase.getInstance(context).predictonsDao()
}
