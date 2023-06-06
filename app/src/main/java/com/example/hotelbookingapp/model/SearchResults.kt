package com.example.hotelbookingapp.model

data class SearchResults(
    val pagination: Pagination,
    val results: List<Result>,
    val totalCount: Int
)