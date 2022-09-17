package com.example.data.di

import com.example.cache.db.ForbesDatabase
import com.example.core.Constants
import com.example.data.api.ForbesListApi
import com.example.data.repositoryimpl.ForbesListRepoImpl
import com.example.domain.repo.ForbesListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

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

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideGithubRestApi(okHttpClient: OkHttpClient): ForbesListApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ForbesListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

}