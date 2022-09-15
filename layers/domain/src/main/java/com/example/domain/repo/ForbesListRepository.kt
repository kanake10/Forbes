package com.example.domain.repo

import com.example.core.Resource
import com.example.domain.models.*
import kotlinx.coroutines.flow.Flow


interface ForbesListRepository {
    suspend fun getAllForbes(): Flow<Resource<List<AllForbes>>>
    suspend fun getOldest(): Flow<Resource<List<Oldest>>>
    suspend fun getYoungest(): Flow<Resource<List<Youngest>>>
    suspend fun getMales(): Flow<Resource<List<Males>>>
    suspend fun getFemales(): Flow<Resource<List<Female>>>
    suspend fun getAccordingToIndustry(): Flow<Resource<List<Industry>>>
}