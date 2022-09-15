package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.entity.AllForbesEntity
import com.example.cache.entity.OldestEntity

@Dao
interface OldestDao {
    @Query("SELECT * FROM oldest_table")
    suspend fun getOldest():List<OldestEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOldest(list: List<OldestEntity>)

    @Query("DELETE FROM oldest_table")
    suspend fun deleteOldest()
}