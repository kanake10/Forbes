package com.example.domain.usecase

import com.example.core.Resource
import com.example.domain.models.AllForbes
import com.example.domain.models.Industry
import com.example.domain.repo.ForbesListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IndustryUseCase @Inject constructor
    (private val repository: ForbesListRepository) {
     operator fun invoke(): Flow<Resource<List<Industry>>> {
        return repository.getAccordingToIndustry()
    }
}