package com.example.currency_api.repository

import com.example.currency_api.entity.ExchangeLog
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeLogRepository : JpaRepository<ExchangeLog, Long> {
}