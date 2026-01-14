package com.example.currency_api.dto

data class CurrencyResponse (
    val source: String,
    val target: String,
    val amount: Double,
    val result: Double
)