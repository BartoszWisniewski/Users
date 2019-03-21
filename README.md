# Project: Users

# Docker:

* Uruchomienie

$ sudo docker run --detach --name=user-db --env="MYSQL_ROOT_PASSWORD=pass1234" --env="TZ=Europe/Warsaw" --publish 6606:3306 mysql

* Stworzenie pustej bazy:

$ docker exec -it user-db bash

$ mysql -u root -p 

create database usertest;

* Usunięcie kontenera:

$ docker rm -f user-db

# Technologies
* Java SE
* Java EE
* Maven
* WildFly
* MySQL
* Hibernate
* Freemarker