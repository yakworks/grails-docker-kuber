import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

scan("5 seconds")

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

//def patternExpression = '%d{HH:mm:ss.SSS} [%t] %-5level %logger{48} - %msg%n'
def patternExpression = '%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} ' + // Date
                        '%clr(%-5level) ' + // Log level
                        '%clr(---){faint} %clr([%t]){faint} ' + // Thread
                        '%clr(%logger{48}){cyan} %clr(:){faint} ' + // Logger
                        '%m%n%wex' // Message
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = java.nio.charset.Charset.forName('UTF-8')
        pattern = patternExpression
    }
}
root(INFO, ['STDOUT'])

logger("grello.HomeController", DEBUG)
