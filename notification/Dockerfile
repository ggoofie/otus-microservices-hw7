FROM bellsoft/liberica-openjdk-alpine-musl:21
COPY target/notification-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]