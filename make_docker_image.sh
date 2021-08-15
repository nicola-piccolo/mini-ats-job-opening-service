#!/bin/bash
current_directory=$(pwd)
./mvnw package && \
	cd target/dependency && \
	jar -xf ../*.jar && \
	cd $current_directory && \
	docker build --tag miniats/job-opening-service --file src/main/resources/static/docker/Dockerfile .