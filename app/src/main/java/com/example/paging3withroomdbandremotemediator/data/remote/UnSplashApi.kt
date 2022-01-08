package com.example.paging3withroomdbandremotemediator.data.remote

import com.example.paging3withroomdbandremotemediator.model.UnsplashImage
import paging3withroomdbandremotemediator.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(@Query("page") page:Int, @Query("per_page") per_page:Int): List<UnsplashImage>



    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(@Query("page") page:Int, @Query("per_page") per_page:Int): List<UnsplashImage>



}