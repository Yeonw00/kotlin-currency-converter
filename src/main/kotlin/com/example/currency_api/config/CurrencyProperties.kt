package com.example.currency_api.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "currency.api")
data class CurrencyProperties(
    val url: String,
    val defaultRate: Double
)