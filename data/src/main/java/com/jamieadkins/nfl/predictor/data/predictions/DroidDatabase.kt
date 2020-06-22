package com.jamieadkins.nfl.predictor.data.predictions

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Prediction::class], version = 1, exportSchema = false)
abstract class PredictionsDatabase : RoomDatabase() {

    abstract fun predictonsDao(): PredictionsDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: PredictionsDatabase? = null

        fun getInstance(context: Context): PredictionsDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PredictionsDatabase {
            return Room.databaseBuilder(context, PredictionsDatabase::class.java, "prediction_db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}