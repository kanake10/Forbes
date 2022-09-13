package com.example.data.api

import com.example.core.Constants.ALL_FORBES_ENDPOINT
import com.example.core.Constants.FEMALE_ENDPOINT
import com.example.core.Constants.INDUSTRY_ENDPOINT
import com.example.core.Constants.MALE_ENDPOINT
import com.example.core.Constants.OLDEST_ENDPOINT
import com.example.core.Constants.YOUNGEST_ENDPOINT
import com.example.data.dtos.*
import retrofit2.http.GET

interface ForbesListApi {
    /**
     * limit param was ignored here
     */
    @GET(ALL_FORBES_ENDPOINT)
    suspend fun getAllForbes():List<AllForbesDto>

    @GET(OLDEST_ENDPOINT)
    suspend fun getOldest(): List<OldestDto>

    @GET(YOUNGEST_ENDPOINT)
    suspend fun getYoungest():  List<YoungestDto>

    @GET(MALE_ENDPOINT)
    suspend fun getMales(): List<MalesDto>

    @GET(FEMALE_ENDPOINT)
    suspend fun getFemales(): List<FemaleDto>
    /**
     * this URL returns data from the retail industry only.To change the industry change the last
     * endpoint from the INDUSTRY_ENDPOINT
     */
    @GET(INDUSTRY_ENDPOINT)
    suspend fun getAccordingToIndustry(): List<IndustryDto>
}