package com.example.hotelbookingapp.model

data class GuestReviews(
    val badge: String,
    val badgeText: String,
    val rating: String,
    val scale: Int,
    val total: Int,
    val unformattedRating: Double
)