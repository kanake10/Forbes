package com.example.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "females_table")
data class FemalesEntity(
    @PrimaryKey(autoGenerate = false)
    val rank: Int?,
    val personName: String?,
    val city: String?,
    val source: String?,
    val industries: List<String>?,
    val countryOfCitizenship: String?,
    val squareImage: String?,
    val bios: List<String>?,
    val abouts: List<String>?
)
