package com.example.domain.models

data class Oldest(
    val rank: Int,
    val finalWorth: Double,
    val personName: String,
    val city: String,
    val source: String,
    val industries: List<String>,
    val countryOfCitizenship: String,
    val squareImage: String,
    val bios: List<String>,
    val abouts: List<String>,
)
