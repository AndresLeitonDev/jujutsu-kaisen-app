# ETAPA 1: Construir el proyecto
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

# ETAPA 2: Ejecutar el proyecto
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/jujutsu-api-1.0.0.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]