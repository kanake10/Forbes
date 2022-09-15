package com.example.domain.di


import com.example.domain.repo.ForbesListRepository
import com.example.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: ForbesListRepository): AllUseCases {
        return AllUseCases(
            allForbesUseCase = AllForbesUseCase(repository),
            femaleUseCase = FemaleUseCase(repository),
            industryUseCase = IndustryUseCase(repository),
            maleUseCase = MaleUseCase(repository),
            oldestUseCase = OldestUseCase(repository),
            youngestUseCase = YoungestUseCase(repository)
        )
    }
}