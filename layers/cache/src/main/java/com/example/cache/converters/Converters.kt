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
    fun fromString(json: String): List<String> {
        return gson.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toString(follow: List<String>): String {
        return gson.toJson(
            follow,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }



}