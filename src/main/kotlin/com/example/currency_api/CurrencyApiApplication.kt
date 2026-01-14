package com.example.currency_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableScheduling
class CurrencyApiApplication{
	@Bean
	fun restTemplate() = RestTemplate()
}

fun main(args: Array<String>) {
	runApplication<CurrencyApiApplication>(*args)
}
