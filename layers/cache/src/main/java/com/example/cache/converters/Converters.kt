package com.example.cache.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.domain.models.Industry
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun listOfStringToString(str: List<String>?): String? {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun strToListString(str: String?): List<String>? {
        return Gson().fromJson(str, object : TypeToken<List<String>>() {}.type)
    }
}