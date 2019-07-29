#!/usr/bin/env bash

./gradlew build
docker build -t yakworks/grello .
# docker push yakworks/grello
# docker run --rm -p 8080:8080 -v "$PWD/extData":/extData yakworks/grello
