package com.example.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.domain.models.Industry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters (
    private val gson:Gson
        ){

    @TypeConverter
    fun fromIndustry(json: String): List<Industry> {
        return gson.fromJson<ArrayList<Industry>>(
            json,
            object : TypeToken<ArrayList<Industry>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toIndustry(follow: List<Industry>): String {
        return gson.toJson(
            follow,
            object : TypeToken<ArrayList<Industry>>() {}.type
        ) ?: "[]"
    }



}