FROM maven:3.6-adoptopenjdk-11 AS MAVEN_BUILD

COPY . vehicles-api
RUN cd vehicles-api && mvn -Dmaven.test.skip=true clean package

FROM adoptopenjdk/openjdk11

ARG artifact_name=vehicles-api-0.0.1-SNAPSHOT.jar
COPY --from=MAVEN_BUILD vehicles-api/target/vehicles-api-0.0.1-SNAPSHOT.jar /usr/local/vehicles-api/

EXPOSE 8082
WORKDIR /usr/local/vehicles-api/
CMD ["java", "-jar",  "vehicles-api-0.0.1-SNAPSHOT.jar"]