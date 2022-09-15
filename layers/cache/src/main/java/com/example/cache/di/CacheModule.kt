package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.db.ForbesDatabase
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
    fun provideForbesDatabase(
        @ApplicationContext context: Context,
    ): ForbesDatabase {
        return Room.databaseBuilder(
            context,
            ForbesDatabase::class.java,
            "forbes_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}