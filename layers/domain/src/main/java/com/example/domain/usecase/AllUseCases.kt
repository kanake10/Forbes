package com.example.domain.usecase

data class AllUseCases (
    val allForbesUseCase: AllForbesUseCase,
    val femaleUseCase: FemaleUseCase,
    val industryUseCase: IndustryUseCase,
    val maleUseCase: MaleUseCase,
    val oldestUseCase: OldestUseCase,
    val youngestUseCase: YoungestUseCase
        )