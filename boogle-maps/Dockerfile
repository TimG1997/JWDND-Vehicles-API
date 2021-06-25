FROM maven:3.6-adoptopenjdk-11 AS MAVEN_BUILD

COPY . boogle-maps
RUN cd boogle-maps && mvn -Dmaven.test.skip=true clean package

FROM adoptopenjdk/openjdk11

ARG artifact_name=boogle-maps-0.0.1-SNAPSHOT.jar
COPY --from=MAVEN_BUILD boogle-maps/target/boogle-maps-0.0.1-SNAPSHOT.jar /usr/local/boogle-maps/

EXPOSE 8082
WORKDIR /usr/local/boogle-maps/
CMD ["java", "-jar",  "boogle-maps-0.0.1-SNAPSHOT.jar"]