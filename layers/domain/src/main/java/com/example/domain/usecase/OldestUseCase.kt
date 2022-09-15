package com.example.domain.usecase

import com.example.core.Resource
import com.example.domain.models.AllForbes
import com.example.domain.models.Oldest
import com.example.domain.repo.ForbesListRepository
import kotlinx.coroutines.flow.Flow

class OldestUseCase (private val repository: ForbesListRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Oldest>>> {
        return repository.getOldest()
    }
}