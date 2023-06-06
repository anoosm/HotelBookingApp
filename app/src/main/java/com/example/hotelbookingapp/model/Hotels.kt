package com.example.hotelbookingapp.model

data class Hotels(
    val filters: Filters,
    val header: String,
    val pointOfSale: PointOfSale,
    val query: Query,
    val searchResults: SearchResults,
    val sortResults: SortResults
)