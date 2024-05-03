FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM openjdk:17-jdk-slim AS runtime


WORKDIR /app


COPY --from=build /app/target/java-project-1.jar .

EXPOSE 8081


CMD ["java", "-jar", "java-project-1.jar"]