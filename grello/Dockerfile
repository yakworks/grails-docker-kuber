FROM openjdk:8-jdk-alpine

# keeps the volumes from run to run
VOLUME /tmp
VOLUME /extData

COPY build/libs/*.jar app.jar
#ENTRYPOINT ["java","-Dloader.path=/extData/conf/", "-jar","/app.jar"]

ENTRYPOINT ["java", "-server", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", \
	"-Xmx2056m", "-XX:MaxMetaspaceSize=128m", \
	"-Dlogging.config=/extData/conf/config-logback.groovy", \
	"-jar","/app.jar"]

# "-Dlogging.config=/extData/conf/config-logback.groovy",
#not sure if this is still needed "-Djava.security.egd=file:/dev/./urandom"