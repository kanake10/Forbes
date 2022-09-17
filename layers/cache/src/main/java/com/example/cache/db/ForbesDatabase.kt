package com.example.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cache.converters.Converters
import com.example.cache.dao.*
import com.example.cache.entity.*

@TypeConverters(Converters::class)
@Database(
    entities = [AccordingToIndustryEntity::class,AllForbesEntity::class,FemalesEntity::class,MalesEntity::class,OldestEntity::class,YoungestEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ForbesDatabase :RoomDatabase(){
    abstract fun AllForbesDao():AllForbesDao
    abstract fun OldestDao():OldestDao
    abstract fun MalesDao():MalesDao
    abstract fun FemalesDao():FemalesDao
    abstract fun YoungestDao():YoungestDao
    abstract fun AccordingDao():AccordingToIndustryDao
}