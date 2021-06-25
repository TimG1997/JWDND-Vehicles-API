FROM maven:3.6-adoptopenjdk-11 AS MAVEN_BUILD

COPY . pricing-service
RUN cd pricing-service && mvn -Dmaven.test.skip=true clean package

FROM adoptopenjdk/openjdk11

ARG artifact_name=pricing-service-0.0.1-SNAPSHOT.jar
COPY --from=MAVEN_BUILD pricing-service/target/pricing-service-0.0.1-SNAPSHOT.jar /usr/local/pricing-service/

EXPOSE 8082
WORKDIR /usr/local/pricing-service/
CMD ["java", "-jar",  "pricing-service-0.0.1-SNAPSHOT.jar"]