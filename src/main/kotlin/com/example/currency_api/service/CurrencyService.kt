package com.example.currency_api.service

import com.example.currency_api.config.CurrencyProperties
import com.example.currency_api.entity.ExchangeLog
import com.example.currency_api.repository.ExchangeLogRepository
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CurrencyService(
    private val logRepository: ExchangeLogRepository,
    private val restTemplate: RestTemplate,
    private val properties: CurrencyProperties
) {

    // 1시간(3600000ms)마다 실행
    @Scheduled(fixedRate = 3600000)
    fun updateExchangeRates() {
        println("자동 환율 업데이트 시작...")

        try {
            val response = restTemplate.getForObject(properties.url, Map::class.java)
            val rates = response?.get("rates") as? Map<String, Any>

            // USD 환율을 대표로 저장하는 예시
            val usdRate = (rates?.get("USD") as? Number)?.toDouble() ?: return

            logRepository.save(
                ExchangeLog(
                    targetCurrency = "USD",
                    sourceAmount = 1.0,
                    resultAmount = usdRate
                )
            )
            println("USD 환율 업데이트 완료: $usdRate")
        } catch(e: Exception) {
            println("업데이트 실패: ${e.message}")
        }
    }
}