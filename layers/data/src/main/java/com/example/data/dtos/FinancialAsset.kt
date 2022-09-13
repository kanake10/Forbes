package com.example.data.dtos

data class FinancialAsset(
    val companyName: String,
    val currencyCode: String,
    val currentPrice: Double,
    val exchange: String,
    val exchangeRate: Double,
    val exerciseOptionPrice: Double,
    val interactive: Boolean,
    val numberOfShares: Double,
    val sharePrice: Double,
    val ticker: String
)