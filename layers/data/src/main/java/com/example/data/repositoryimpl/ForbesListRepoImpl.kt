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
    override fun getAllForbes(): Flow<Resource<List<AllForbes>>> = flow {
        emit(Resource.Loading())

        val allforb = allForbesDao.getAllForbes()
        emit(Resource.Loading(data = allforb.map { it.toDomain() }))

        try {
            val apiResponseForAll = forbesListApi.getAllForbes()
            allForbesDao.deleteAllForbes()
            allForbesDao.insertAllForbes(apiResponseForAll.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = allforb.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = allforb.map { it.toDomain() }
                )
            )
        }
        val AllData = allForbesDao.getAllForbes().map { it.toDomain() }
        emit(Resource.Success(AllData))
    }

    override fun getOldest(): Flow<Resource<List<Oldest>>> = flow {
        emit(Resource.Loading())

        val databaseOldestData = oldestDao.getOldest()
        emit(Resource.Loading(data = databaseOldestData.map { it.toDomain() }))

        try {
            val apiResponseForOldest = forbesListApi.getOldest()
            oldestDao.deleteOldest()
            oldestDao.insertOldest(apiResponseForOldest.map { it.toEntity() })
        } catch (exception: IOException) {
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

    override fun getYoungest(): Flow<Resource<List<Youngest>>> = flow {
        emit(Resource.Loading())

        val databaseYoungestData = youngestDao.getYoungest()
        emit(Resource.Loading(data = databaseYoungestData.map { it.toDomain() }))

        try {
            val apiResponseForYoungest = forbesListApi.getYoungest()
            youngestDao.deleteYoungest()
            youngestDao.insertYoungest(apiResponseForYoungest.map { it.toEntity() })
        } catch (exception: IOException) {
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

    override fun getMales(): Flow<Resource<List<Males>>> = flow {
        emit(Resource.Loading())

        val databasemalesData = malesDao.getMales()
        emit(Resource.Loading(data = databasemalesData.map { it.toDomain() }))

        try {
            val apiResponseForMales = forbesListApi.getMales()
            malesDao.deleteMales()
            malesDao.insertMales(apiResponseForMales.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databasemalesData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databasemalesData.map { it.toDomain() }
                )
            )
        }
        val malesData = malesDao.getMales().map { it.toDomain() }
        emit(Resource.Success(malesData))
    }

    override fun getFemales(): Flow<Resource<List<Female>>> = flow {
        emit(Resource.Loading())

        val databaseFemaleData = femalesDao.getFemales()
        emit(Resource.Loading(data = databaseFemaleData.map { it.toDomain() }))

        try {
            val apiResponseForFemales = forbesListApi.getFemales()
            femalesDao.deleteFemales()
            femalesDao.insertFemales(apiResponseForFemales.map { it.toEntity() })
        } catch (exception: IOException) {
            emit(
                Resource.Error(
                    message = "Connection Lost",
                    data = databaseFemaleData.map { it.toDomain() }
                )
            )
        } catch (exception: HttpException) {
            emit(
                Resource.Error(
                    message = exception.message(),
                    data = databaseFemaleData.map { it.toDomain() }
                )
            )
        }
        val femaleData = femalesDao.getFemales().map { it.toDomain() }
        emit(Resource.Success(femaleData))
    }

    override fun getAccordingToIndustry(): Flow<Resource<List<Industry>>> = flow {
        emit(Resource.Loading())

        val databaseIndustryData = accordingToIndustryDao.getIndustry()
        emit(Resource.Loading(data = databaseIndustryData.map { it.toDomain() }))

        try {
            val apiResponseForIndustry = forbesListApi.getAccordingToIndustry()
            accordingToIndustryDao.deleteIndustry()
            accordingToIndustryDao.insertIndustry(apiResponseForIndustry.map { it.toEntity() })
        } catch (exception: IOException) {
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