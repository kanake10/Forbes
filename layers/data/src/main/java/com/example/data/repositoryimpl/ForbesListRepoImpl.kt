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
        emit(Resource.Loading())

        val databaseOldestData = oldestDao.getOldest()
        emit(Resource.Loading(data = databaseOldestData.map { it.toDomain() }))

        try {
            val apiResponseTwo = forbesListApi.getOldest()
            oldestDao.deleteOldest()
            oldestDao.insertOldest(apiResponseTwo.map { it.toEntity() })
        }catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseOldestData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseOldestData.map { it.toDomain() }
                )
            )
        }
        val oldestData = oldestDao.getOldest().map { it.toDomain() }
        emit(Resource.Success(oldestData))
    }

    override suspend fun getYoungest(): Flow<Resource<List<Youngest>>> = flow {
        emit(Resource.Loading())

        val databaseYoungestData = youngestDao.getYoungest()
        emit(Resource.Loading(data = databaseYoungestData.map { it.toDomain() }))

        try {
            val apiResponseThree = forbesListApi.getYoungest()
            youngestDao.deleteYoungest()
            youngestDao.insertYoungest(apiResponseThree.map { it.toEntity() })
        }catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseYoungestData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseYoungestData.map { it.toDomain() }
                )
            )
        }
        val youngestData = youngestDao.getYoungest().map { it.toDomain() }
        emit(Resource.Success(youngestData))
    }

    override suspend fun getMales(): Flow<Resource<List<Males>>> = flow {
        emit(Resource.Loading())

        val databaseMalesData = malesDao.getMales()
        emit(Resource.Loading(data = databaseMalesData.map { it.toDomain() }))

        try {
            val apiResponseFour = forbesListApi.getMales()
            malesDao.deleteMales()
            malesDao.insertMales(apiResponseFour.map { it.toEntity() })
        }catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseMalesData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseMalesData.map { it.toDomain() }
                )
            )
        }
        val malesData = malesDao.getMales().map { it.toDomain() }
        emit(Resource.Success(malesData))
    }

    override suspend fun getFemales(): Flow<Resource<List<Female>>> = flow {
        emit(Resource.Loading())

        val databaseFemalesData = femalesDao.getFemales()
        emit(Resource.Loading(data = databaseFemalesData.map { it.toDomain() }))

        try {
            val apiResponseFive = forbesListApi.getFemales()
            femalesDao.deleteFemales()
            femalesDao.insertFemales(apiResponseFive.map { it.toEntity() })
        }catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseFemalesData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseFemalesData.map { it.toDomain() }
                )
            )
        }
        val femalesData = femalesDao.getFemales().map { it.toDomain() }
        emit(Resource.Success(femalesData))
    }

    override suspend fun getAccordingToIndustry(): Flow<Resource<List<Industry>>> = flow {
        emit(Resource.Loading())

        val databaseIndustryData =  accordingToIndustryDao.getIndustry()
        emit(Resource.Loading(data = databaseIndustryData.map { it.toDomain() }))

        try {
            val apiResponseSix = forbesListApi.getAccordingToIndustry()
            accordingToIndustryDao.deleteIndustry()
            accordingToIndustryDao.insertIndustry(apiResponseSix.map { it.toEntity() })
        }catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseIndustryData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseIndustryData.map { it.toDomain() }
                )
            )
        }
        val industryData = accordingToIndustryDao.getIndustry().map { it.toDomain() }
        emit(Resource.Success(industryData))
    }
}