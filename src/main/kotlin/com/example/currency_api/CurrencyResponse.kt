package com.example.currency_api

data class CurrencyResponse (
    val source: String,
    val target: String,
    val amount: Double,
    val result: Double
)


