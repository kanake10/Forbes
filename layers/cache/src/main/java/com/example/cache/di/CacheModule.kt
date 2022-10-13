package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.converters.Converters
import com.example.cache.db.ForbesDatabase
import com.example.core.Constants.FORBES_DB
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): ForbesDatabase {
        return ForbesDatabase.getInstance(context)
    }

}

