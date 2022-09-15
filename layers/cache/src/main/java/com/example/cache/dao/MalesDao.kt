package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.MalesEntity
import com.example.cache.entity.YoungestEntity

@Dao
interface MalesDao {
    @Query("SELECT * FROM males_table")
    suspend fun getMales():List<MalesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMales(list: List<MalesEntity>)
}