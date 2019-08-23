#!/usr/bin/env bash

./gradlew build
# Can test this with
# java -jar build/libs/grello-0.1.jar

docker build -t yakworks/grello .
docker push yakworks/grello
