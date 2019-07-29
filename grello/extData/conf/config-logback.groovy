import ch.qos.logback.classic.filter.ThresholdFilter

//Logback manual: https://logback.qos.ch/manual/index.html
statusListener ch.qos.logback.core.status.NopStatusListener //turns off logbacks own logging

String logsDir = "/extData/logs"

println "### Using external logback.groovy"
println "### logs directory is: $logsDir"


appender("AppErrors", FileAppender) { //use RollingFileAppender in prodcution
	file = "${logsDir}/errors.log"
	append = false

	encoder(PatternLayoutEncoder) {
		pattern = "%date [%t] [%-5level] %logger{30} - %msg%n %exception{10}"
	}

	filter(ThresholdFilter) {
		level = "ERROR"
	}

	// rollingPolicy(TimeBasedRollingPolicy) {
	// 	fileNamePattern = "${logsDir}/9ci-errors.log.%d{yyyy-MM-dd}"
	// }
}

appender("AppInfo", FileAppender) {
	file = "${logsDir}/info.log"
	append = false

	encoder(PatternLayoutEncoder) {
		pattern = "%date [%t] [%-5level] %logger{30} - %msg%n %exception{10}"
	}

	filter(ThresholdFilter) {
		level = "INFO"
	}

	// rollingPolicy(TimeBasedRollingPolicy) {
	// 	fileNamePattern = "${logsDir}/9ci-info.log.%d{yyyy-MM-dd}"
	// }
}

appender("FULL_STACKTRACE", FileAppender) {
	file = "${logsDir}/stacktrace.log"
	append = false

	encoder(PatternLayoutEncoder) {
		pattern = "%date [%t] [%-5level] %logger{30} - %msg%n %exception{full}"
	}

	// rollingPolicy(TimeBasedRollingPolicy) {
	// 	fileNamePattern = "${logsDir}/9ci-stacktrace.log.%d{yyyy-MM-dd}"
	// }
}

logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)

root(INFO, ["AppInfo", "AppErrors"])
