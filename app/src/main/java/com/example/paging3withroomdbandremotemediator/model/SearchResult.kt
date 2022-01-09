package com.example.paging3withroomdbandremotemediator.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(

    @SerialName("results")
    val images: List<UnsplashImage>

)
