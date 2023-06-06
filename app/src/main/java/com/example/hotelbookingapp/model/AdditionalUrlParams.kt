package com.example.hotelbookingapp.model

import com.google.gson.annotations.SerializedName

data class AdditionalUrlParams(
    @SerializedName("destination-id")
    val destinationId: String,
    @SerializedName("q-destination")
    val qDestination: String,
    @SerializedName("resolved-location")
    val resolvedLocation: String
)