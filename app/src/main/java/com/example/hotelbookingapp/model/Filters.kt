package com.example.hotelbookingapp.model

data class Filters(
    val accessibility: Accessibility,
    val accommodationType: AccommodationType,
    val applied: Boolean,
    val facilities: Facilities,
    val guestRating: GuestRating,
    val landmarks: Landmarks,
    val name: Name,
    val neighbourhood: Neighbourhood,
    val paymentPreference: PaymentPreference,
    val price: Price,
    val starRating: StarRating,
    val themesAndTypes: ThemesAndTypes,
    val welcomeRewards: WelcomeRewards
)