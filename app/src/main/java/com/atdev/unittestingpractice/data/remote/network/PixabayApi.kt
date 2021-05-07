package com.atdev.unittestingpractice.data.remote.network

import com.atdev.unittestingpractice.BuildConfig
import com.atdev.unittestingpractice.core.entities.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api/")
    suspend fun searchImages(
        @Query("q") searchKey: String,
        @Query("key") apiKey: String = BuildConfig.APi_KRY_Pixabay
    ): Response<ImageResponse>
}