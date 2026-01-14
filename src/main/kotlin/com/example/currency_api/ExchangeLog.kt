package com.example.currency_api

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class ExchangeLog(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val targetCurrency: String = "",
    val sourceAmount: Double = 0.0,
    val resultAmount: Double = 0.0,
    val createdAt: LocalDateTime = LocalDateTime.now()
)

