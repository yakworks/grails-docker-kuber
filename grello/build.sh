#!/usr/bin/env bash

./gradlew build
docker build -t yakworks/grello .
# docker push yakworks/grello
# docker run --rm -p 8080:8080 \
# -e LOGGING_CONFIG='/extData/conf/config-logback.groovy' \
# -v $(pwd)/extData:/extData yakworks/grello
