package com.example.hotelbookingapp.network

import com.example.hotelbookingapp.model.Hotels
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key:key")
    @GET("v1/hotels/search")
    fun getListOfHotels(
        @Query("checkin_date") checkin: String,
        @Query("checkout_date") checkOut: String,
        @Query("sort_order") sortOrder: String,
        @Query("destination_id") destId: Int,
        @Query("adults_number") adultsNumber: Int,
        @Query("currency") currency: String,
        @Query("locale") locale: String,
        ): Call<Hotels>
}