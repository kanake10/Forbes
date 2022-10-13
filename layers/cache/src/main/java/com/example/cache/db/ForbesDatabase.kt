package com.example.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache.converters.Converters
import com.example.cache.dao.*
import com.example.cache.entity.*
import com.example.core.Constants.FORBES_DB

@TypeConverters(Converters::class)
@Database(
    entities = [AccordingToIndustryEntity::class,AllForbesEntity::class,FemalesEntity::class,MalesEntity::class,OldestEntity::class,YoungestEntity::class],
    version = 4,
    exportSchema = false
)
abstract class ForbesDatabase :RoomDatabase(){

    companion object {
        fun getInstance(context: Context): ForbesDatabase {
            return Room.databaseBuilder(context, ForbesDatabase::class.java, FORBES_DB)
                .fallbackToDestructiveMigration()
                .build()
        }
    }




    abstract fun AllForbesDao():AllForbesDao
    abstract fun OldestDao():OldestDao
    abstract fun MalesDao():MalesDao
    abstract fun FemalesDao():FemalesDao
    abstract fun YoungestDao():YoungestDao
    abstract fun AccordingDao():AccordingToIndustryDao
}