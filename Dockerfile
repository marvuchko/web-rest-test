FROM maven:3.8.4-eclipse-temurin-17 as build
WORKDIR /app
COPY . /app
RUN clean install

FROM eclipse-temurin:17-jre
COPY --from=build /app/application/target/*.jar /app.jar
EXPOSE 8080
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]