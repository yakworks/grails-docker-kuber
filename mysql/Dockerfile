FROM mysql:5.7

#see https://serverfault.com/questions/796762/creating-a-docker-mysql-container-with-a-prepared-database-scheme/796778

# keeps the volumes from run to run
COPY ./mysql-init-db.sql /docker-entrypoint-initdb.d/