#!/usr/bin/env bash

docker stop mysql-grello || true && docker rm mysql-grello || true

docker run --name=mysql-grello \
-e MYSQL_ROOT_PASSWORD=123Foobar \
-e MYSQL_ROOT_HOST=% \
-e MYSQL_DATABASE=grello-db \
-d -p 3306:3306 yakworks/grello-mysql

sleep 10 #wait for mysql to start

#cat mysql-init-db.sql | docker exec -i mysql-grello /usr/bin/mysql -u root --password=123Foobar grello-db

docker run --rm -p 8080:8080 \
 --link mysql-grello \
 -e LOGGING_CONFIG='/extData/conf/config-logback.groovy' \
 -v $(pwd)/grello/extData:/extData \
 yakworks/grello