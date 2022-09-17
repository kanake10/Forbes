package com.example.domain.repo

import com.example.core.Resource
import com.example.domain.models.*
import kotlinx.coroutines.flow.Flow


interface ForbesListRepository {
     fun getAllForbes(): Flow<Resource<List<AllForbes>>>
     fun getOldest(): Flow<Resource<List<Oldest>>>
     fun getYoungest(): Flow<Resource<List<Youngest>>>
     fun getMales(): Flow<Resource<List<Males>>>
     fun getFemales(): Flow<Resource<List<Female>>>
     fun getAccordingToIndustry(): Flow<Resource<List<Industry>>>
}