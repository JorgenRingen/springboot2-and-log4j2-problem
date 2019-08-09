# Kotlin + Spring Boot + Log4J2 + Slf4J + Gradle

#### Description
Shows how to configure log4j2. Notice the exclusion of `spring-boot-starter-logging` and `logback` in `build.gradle.kts` in order to exclude logback which is default provided by spring-boot. 

#### log4j2.xml
Used in production. Use the [JSONLayout](https://logging.apache.org/log4j/2.x/manual/layouts.html#JSONLayout) for all
 appenders.
 Root level is info. This may be overridden by explicit Loggers.
 
Remember to update the `service-name` value to the application name.
 
#### log4j2-test.xml
Used for all unit-tests and may be used for local development. Uses standard [PatternLayout](https://logging.apache.org/log4j/2.x/manual/layouts.html#PatternLayout) for better readability while debugging. Root level is error.

Run application locally using log4j2-test.xml in Intellij:

Run -> Edit Configurations -> Spring Boot -> Application
```
working directory=$MODULE_WORKING_DIR$
logging.config=src/test/resources/log4j2-test.xml
```

#### Sample output using JsonLayout:
```js
{"thread":"main","level":"INFO","loggerName":"com.example.logbackvslog4j2.Log4J2SampleApplicationKt","message":"Started Log4J2SampleApplicationKt in 0.593 seconds (JVM running for 1.27)","endOfBatch":false,"loggerFqcn":"org.apache.commons.logging.LogAdapter$Log4jLog","instant":{"epochSecond":1565598479,"nanoOfSecond":838404000},"contextMap":{},"threadId":1,"threadPriority":5,"timestamp":"2019-08-12T10:27:59.838+0200","serviceName":"logging-sample-app"}
{"thread":"main","level":"INFO","loggerName":"com.example.logbackvslog4j2.Log4J2SampleApplication","message":"Example message!","endOfBatch":false,"loggerFqcn":"org.apache.logging.slf4j.Log4jLogger","instant":{"epochSecond":1565598479,"nanoOfSecond":839277000},"contextMap":{},"threadId":1,"threadPriority":5,"timestamp":"2019-08-12T10:27:59.839+0200","serviceName":"logging-sample-app"}
{"thread":"main","level":"INFO","loggerName":"com.example.logbackvslog4j2.Log4J2SampleApplication","message":"Example parameterized message! Parameter=42","endOfBatch":false,"loggerFqcn":"org.apache.logging.slf4j.Log4jLogger","instant":{"epochSecond":1565598479,"nanoOfSecond":840697000},"contextMap":{},"threadId":1,"threadPriority":5,"timestamp":"2019-08-12T10:27:59.840+0200","serviceName":"logging-sample-app"}
{"thread":"main","level":"INFO","loggerName":"com.example.logbackvslog4j2.Log4J2SampleApplication","message":"Example message with MDC","endOfBatch":false,"loggerFqcn":"org.apache.logging.slf4j.Log4jLogger","instant":{"epochSecond":1565598479,"nanoOfSecond":846828000},"contextMap":{"traceId":"1dc06a0c-44a3-4a94-81f4-fab5d5fc91b2"},"threadId":1,"threadPriority":5,"timestamp":"2019-08-12T10:27:59.846+0200","serviceName":"logging-sample-app"}
{"thread":"main","level":"ERROR","loggerName":"com.example.logbackvslog4j2.Log4J2SampleApplication","message":"Example error message","thrown":{"commonElementCount":0,"localizedMessage":"🔥","message":"🔥","name":"java.lang.RuntimeException","extendedStackTrace":"java.lang.RuntimeException: 🔥\n\tat com.example.logbackvslog4j2.Log4J2SampleApplication$commandLineRunner$1.run(Log4J2SampleApplication.kt:26) [main/:?]\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:780) [spring-boot-2.1.7.RELEASE.jar:2.1.7.RELEASE]\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:764) [spring-boot-2.1.7.RELEASE.jar:2.1.7.RELEASE]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:319) [spring-boot-2.1.7.RELEASE.jar:2.1.7.RELEASE]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1214) [spring-boot-2.1.7.RELEASE.jar:2.1.7.RELEASE]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1203) [spring-boot-2.1.7.RELEASE.jar:2.1.7.RELEASE]\n\tat com.example.logbackvslog4j2.Log4J2SampleApplicationKt.main(Log4J2SampleApplication.kt:35) [main/:?]\n"},"endOfBatch":false,"loggerFqcn":"org.apache.logging.slf4j.Log4jLogger","instant":{"epochSecond":1565598479,"nanoOfSecond":847310000},"contextMap":{},"threadId":1,"threadPriority":5,"timestamp":"2019-08-12T10:27:59.847+0200","serviceName":"logging-sample-app"}

```