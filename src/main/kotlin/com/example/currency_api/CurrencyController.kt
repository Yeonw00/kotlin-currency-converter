package com.example.currency_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class CurrencyController(
    private val logRepository: ExchangeLogRepository,
    private val restTemplate: RestTemplate,
    private val properties: CurrencyProperties
) {

    @GetMapping("/api/convert")
    fun convert(
        @RequestParam amount: Double,
        @RequestParam target: String
    ): CurrencyResponse {
        require(amount > 0) {"금액은 0보다 커야 합니다."}
        require(target.length == 3) {"통화 코드는 3자리여야 합니다. (예: USD)"}

        // 고정 환율
//        val rate = (rates?.get(target.uppercase()) as? Number)?.toDouble
//          ?: properties.defaultRate
//        val result = amount / rate

        val response = restTemplate.getForObject(properties.url, Map::class.java)

        val rates = response?.get("rates") as? Map<String, Any>
        val rate = (rates?.get(target) as? Number)?.toDouble()
            ?: throw IllegalArgumentException("지원하지 않는 통화 코드입니다: $target")

        val result = amount * rate // KRW 기준이므로 곱하기

        val log = ExchangeLog(
            targetCurrency =  target,
            sourceAmount = amount,
            resultAmount = result
        )
        logRepository.save(log)

        return CurrencyResponse("KRW", target, amount, result)
    }

    @GetMapping("/api/logs")
    fun getLogs() = logRepository.findAll()
}