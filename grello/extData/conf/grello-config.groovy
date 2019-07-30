println "### reading external config grello-config.groovy"

//sets up tomcat logging
server.tomcat.accesslog.enabled=true
server.tomcat.accesslog.directory="/extData/logs"

grello {
	message = "Hi from extData grello-config.groovy"
}
