package com.jamieadkins.nfl.predictor.data

import com.jamieadkins.nfl.predictor.domain.MatchesRepository
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
class MatchesDataModule {

    @Provides
    @Singleton
    fun providesContentRetrofit(okHttpClient: Lazy<OkHttpClient>): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://site.api.espn.com/apis/site/v2/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .callFactory { okHttpClient.get().newCall(it) }
            .build()
    }

    @Provides
    @Singleton
    fun service(retrofit: Retrofit): FootballService = retrofit.create(FootballService::class.java)

    @Provides
    @Singleton
    fun matchesRepository(matchesRepositoryImpl: MatchesRepositoryImpl): MatchesRepository = matchesRepositoryImpl

}