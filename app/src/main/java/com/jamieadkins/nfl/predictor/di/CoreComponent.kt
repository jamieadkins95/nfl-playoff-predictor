package com.jamieadkins.nfl.predictor.di

import android.content.Context
import com.jamieadkins.nfl.predictor.PredictorApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [])
@Singleton
interface CoreComponent {

    @ApplicationContext
    fun exposeContext(): Context

    fun inject(target: PredictorApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(@ApplicationContext context: Context): Builder

        fun build(): CoreComponent
    }
}