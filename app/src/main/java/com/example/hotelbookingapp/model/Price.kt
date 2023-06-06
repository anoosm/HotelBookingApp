package com.example.hotelbookingapp.model

data class Price(
    val applied: Boolean,
    val label: String,
    val multiplier: Int,
    val range: RangeX
)