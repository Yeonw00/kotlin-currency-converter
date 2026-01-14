package com.example.currency_api

import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeLogRepository : JpaRepository<ExchangeLog, Long> {
}