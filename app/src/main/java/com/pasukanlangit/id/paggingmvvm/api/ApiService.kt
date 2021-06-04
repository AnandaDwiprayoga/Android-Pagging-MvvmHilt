package com.pasukanlangit.id.paggingmvvm.api

import com.pasukanlangit.id.paggingmvvm.models.ApiResponse
import com.pasukanlangit.id.paggingmvvm.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(
        @Query("page") page:Int
    ): Response<ApiResponse>
}