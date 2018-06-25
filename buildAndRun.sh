#!/usr/bin/env bash

docker-compose up -d
#mvn clean install && docker build -t recipe-app-docker .
#docker rm -f recipe-app || true && docker run -d -p 8080:8080 --name recipe-app recipe-app-docker
mvn spring-boot:run