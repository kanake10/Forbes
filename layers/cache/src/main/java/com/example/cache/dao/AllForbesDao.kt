package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.AllForbesEntity

@Dao
interface AllForbesDao {
    @Query("SELECT * FROM all_forbes_table")
    suspend fun getAllForbes():List<AllForbesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllForbes(list: List<AllForbesEntity>)

    @Query("DELETE FROM all_forbes_table")
    suspend fun deleteAllForbes()
}