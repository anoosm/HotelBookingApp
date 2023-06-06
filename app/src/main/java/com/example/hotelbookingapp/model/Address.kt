package com.example.hotelbookingapp.model

data class Address(
    val countryCode: String,
    val countryName: String,
    val extendedAddress: String,
    val locality: String,
    val obfuscate: Boolean,
    val postalCode: String,
    val region: String,
    val streetAddress: String
)