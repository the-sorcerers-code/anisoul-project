FROM maven:3.8.6-amazoncorretto-19 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

# Compile and package the application to an executable JAR
RUN mvn -DskipTests=true package

# For Java 19,
FROM amazoncorretto:19

ARG JAR_FILE=anisoul-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app

EXPOSE 8085


ENTRYPOINT ["java","-jar", "anisoul-0.0.1-SNAPSHOT.jar"]