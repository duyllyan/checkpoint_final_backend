FROM openjdk:19-jdk-alpine3.15
WORKDIR /serie-service
EXPOSE 8092
COPY target/series-service.jar /series-service/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]