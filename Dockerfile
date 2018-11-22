FROM openjdk:11-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/buyers-api-1.0-SNAPSHOT.jar /app

EXPOSE 8081

CMD java -jar buyers-api-1.0-SNAPSHOT.jar