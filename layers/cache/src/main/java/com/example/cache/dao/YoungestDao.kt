package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.OldestEntity
import com.example.cache.entity.YoungestEntity

@Dao
interface YoungestDao {
    @Query("SELECT * FROM youngest_table")
    suspend fun getYoungest():List<YoungestEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertYoungest(list: List<YoungestEntity>)
}