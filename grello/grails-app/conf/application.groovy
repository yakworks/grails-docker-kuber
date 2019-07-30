
//loads common configs for testing and dev from nine/* with configLocations
grails {
    config.locations =  [
            "file:/extData/conf/grello-config.groovy"
    ]
}

//sets up tomcat logging
//server.tomcat.accesslog.enabled=true
//server.tomcat.accesslog.directory="/extData/logs"

//simple config so we can know if its picking up config
grello {
	message = "Hi from application.groovy"
}
