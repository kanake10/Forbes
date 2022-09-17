package com.example.data.di

import com.example.cache.db.ForbesDatabase
import com.example.data.api.ForbesListApi
import com.example.data.repositoryimpl.ForbesListRepoImpl
import com.example.domain.repo.ForbesListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideForbesRepository(
        forbesApi:ForbesListApi,
        forbesDatabase:ForbesDatabase
    ):ForbesListRepository{
        return ForbesListRepoImpl(
            forbesListApi = forbesApi,
            accordingToIndustryDao = forbesDatabase.AccordingDao(),
            allForbesDao = forbesDatabase.AllForbesDao(),
            femalesDao = forbesDatabase.FemalesDao(),
            malesDao = forbesDatabase.MalesDao(),
            oldestDao = forbesDatabase.OldestDao(),
            youngestDao = forbesDatabase.YoungestDao()
        )
    }
}