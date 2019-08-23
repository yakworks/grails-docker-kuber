#!/usr/bin/env bash

docker run --rm -p 8080:8080 \
-e LOGGING_CONFIG='/config-logback.groovy' \
-v $(pwd)/extData/conf/config-logback.groovy:/config-logback.groovy yakworks/grello
