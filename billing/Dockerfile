FROM bellsoft/liberica-openjdk-alpine-musl:21
COPY target/billing-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]