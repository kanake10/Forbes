package com.example.domain.usecase

import com.example.core.Resource
import com.example.domain.models.AllForbes
import com.example.domain.models.Female
import com.example.domain.repo.ForbesListRepository
import kotlinx.coroutines.flow.Flow

class FemaleUseCase (private val repository: ForbesListRepository) {
     operator fun invoke(): Flow<Resource<List<Female>>> {
        return repository.getFemales()
    }
}