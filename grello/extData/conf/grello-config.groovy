println "### reading external config grello-config.groovy"

//sets up tomcat logging
server.tomcat.accesslog.enabled=true
server.tomcat.accesslog.directory="/extData/logs"

grello {
	message = "Hi from extData grello-config.groovy"
}

dataSource{
	url = "jdbc:mysql://mysql-grello:3306/grello-db"
	driverClassName= "com.mysql.jdbc.Driver"
	username = "root"
	password = "123Foobar"
}

hibernate.dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
