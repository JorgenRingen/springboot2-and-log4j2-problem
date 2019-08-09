package com.example.logbackvslog4j2

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.lang.invoke.MethodHandles

@RunWith(SpringRunner::class)
@SpringBootTest
class Log4J2SampleApplicationTests {

    companion object {
        private val logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    }

    @Test
    fun contextLoads() {
        logger.info("Logging from test...")
    }

}
