FROM eclipse-temurin:17-jdk-alpine

# Instala Maven
RUN apk add --no-cache maven

WORKDIR /app

# Copiar archivos
COPY pom.xml .
COPY src ./src

# Build con Maven
RUN mvn clean package

# Exponer puerto
EXPOSE 10000

# Ejecutar app
CMD ["java", "-jar", "target/prueba-tickets-0.0.1-SNAPSHOT.jar"]
