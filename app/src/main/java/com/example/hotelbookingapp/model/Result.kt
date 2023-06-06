package com.example.hotelbookingapp.model

data class Result(
    val address: Address,
    val badging: Badging,
    val coordinate: Coordinate,
    val deals: Deals,
    val geoBullets: List<Any>,
    val guestReviews: GuestReviews,
    val id: Int,
    val isAlternative: Boolean,
    val landmarks: List<Landmark>,
    val messaging: Messaging,
    val name: String,
    val neighbourhood: String,
    val optimizedThumbUrls: OptimizedThumbUrls,
    val pimmsAttributes: String,
    val providerType: String,
    val ratePlan: RatePlan,
    val roomsLeft: Int,
    val starRating: Double,
    val supplierHotelId: Int,
    val urls: Urls,
    val vrBadge: String,
    val welcomeRewards: WelcomeRewardsX
)