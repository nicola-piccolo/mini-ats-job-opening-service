FROM openjdk:12-jdk-alpine

RUN addgroup -S job-opening-service && adduser -S job-opening-service -G job-opening-service

ENV HOME_DIRECTORY="/home/job-opening-service"
ENV LOGS_DIRECTORY="$HOME_DIRECTORY/logs"

USER job-opening-service:job-opening-service

RUN mkdir $LOGS_DIRECTORY

ARG DEPENDENCY=target/dependency

COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","org.miniats.jobopeningservice.JobOpeningServiceApplication"]