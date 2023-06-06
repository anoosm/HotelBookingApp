package com.example.hotelbookingapp.model

data class Pagination(
    val currentPage: Int,
    val nextPageGroup: String,
    val nextPageNumber: Int,
    val nextPageStartIndex: Int,
    val pageGroup: String
)