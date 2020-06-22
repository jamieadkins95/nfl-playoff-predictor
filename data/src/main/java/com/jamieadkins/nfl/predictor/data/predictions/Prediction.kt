package com.jamieadkins.nfl.predictor.data.predictions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "predictions")
data class Prediction(
    @PrimaryKey @ColumnInfo(name = "matchId") val matchId: String,
    @ColumnInfo(name = "season") val season: Int,
    @ColumnInfo(name = "outcome") val outcome: String
)