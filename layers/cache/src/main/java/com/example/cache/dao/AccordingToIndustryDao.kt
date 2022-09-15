package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.AccordingToIndustryEntity
import com.example.cache.entity.FemalesEntity

@Dao
interface AccordingToIndustryDao {
    @Query("SELECT * FROM according_to_industry_table")
    suspend fun getIndustry():List<AccordingToIndustryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIndustry(list: List<AccordingToIndustryEntity>)

    @Query("DELETE FROM according_to_industry_table")
    suspend fun deleteIndustry()
}