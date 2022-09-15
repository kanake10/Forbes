package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.FemalesEntity
import com.example.cache.entity.MalesEntity

@Dao
interface FemalesDao {
    @Query("SELECT * FROM females_table")
    suspend fun getFemales():List<FemalesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFemales(list: List<FemalesEntity>)
}