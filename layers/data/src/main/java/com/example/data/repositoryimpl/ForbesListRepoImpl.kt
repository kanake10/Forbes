package com.example.data.repositoryimpl

import com.example.cache.dao.*
import com.example.core.Resource
import com.example.data.api.ForbesListApi
import com.example.data.mappers.toDomain
import com.example.data.mappers.toEntity
import com.example.domain.models.*
import com.example.domain.repo.ForbesListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ForbesListRepoImpl(
    private val forbesListApi: ForbesListApi,
    private val accordingToIndustryDao: AccordingToIndustryDao,
    private val allForbesDao: AllForbesDao,
    private val femalesDao: FemalesDao,
    private val malesDao: MalesDao,
    private val oldestDao: OldestDao,
    private val youngestDao: YoungestDao
) : ForbesListRepository {
    override suspend fun getAllForbes(): Flow<Resource<List<AllForbes>>> = flow {
        emit(Resource.Loading())

        val getAllForbesFromDb = allForbesDao.getAllForbes().map { it.toDomain() }
        Resource.Loading(data = getAllForbesFromDb)

        try {
            val apiResponse = forbesListApi.getAllForbes()
            allForbesDao.deleteAllForbes()
            allForbesDao.insertAllForbes(apiResponse.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = getAllForbesFromDb
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = getAllForbesFromDb
                )
            )
        }
        val allForbes = allForbesDao.getAllForbes().map { it.toDomain() }
        emit(Resource.Success(allForbes))
    }

    override suspend fun getOldest(): Flow<Resource<List<Oldest>>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun getYoungest(): Flow<Resource<List<Youngest>>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun getMales(): Flow<Resource<List<Males>>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun getFemales(): Flow<Resource<List<Female>>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun getAccordingToIndustry(): Flow<Resource<List<Industry>>> = flow {
        TODO("Not yet implemented")
    }
}