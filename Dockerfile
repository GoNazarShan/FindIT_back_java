FROM maven:3.9-eclipse-temurin-21-alpine
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
COPY --from=build /app/src/main/resources /app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
