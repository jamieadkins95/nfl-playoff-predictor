package com.jamieadkins.nfl.predictor.data.predictions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PredictionsDao {

    @Query("SELECT * FROM predictions WHERE season=:season")
    fun getPredictions(season: Int): Observable<List<Prediction>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(prediction: Prediction): Completable

}