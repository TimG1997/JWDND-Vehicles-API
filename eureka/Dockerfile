FROM maven:3.6-adoptopenjdk-11 AS MAVEN_BUILD

COPY . eureka
RUN cd eureka && mvn -Dmaven.test.skip=true clean package

FROM adoptopenjdk/openjdk11

ARG artifact_name=eureka-0.0.1-SNAPSHOT.jar
COPY --from=MAVEN_BUILD eureka/target/eureka-0.0.1-SNAPSHOT.jar /usr/local/eureka/

EXPOSE 8761
WORKDIR /usr/local/eureka/
CMD ["java", "-jar",  "eureka-0.0.1-SNAPSHOT.jar"]