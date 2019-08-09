package com.example.logbackvslog4j2

import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.lang.invoke.MethodHandles
import java.util.UUID

@SpringBootApplication
class Log4J2SampleApplication {

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }

    @Bean
    fun commandLineRunner() = CommandLineRunner {
        logger.info("Example message!")
        logger.info("Example parameterized message: parameter={}", 42)

        MDC.put("traceId", UUID.randomUUID().toString())
        logger.info("Example message with MDC")
        MDC.remove("traceId")

        logger.error("Example error message", RuntimeException("🔥"))
    }
}


fun main(args: Array<String>) {
    runApplication<Log4J2SampleApplication>(*args)
}
