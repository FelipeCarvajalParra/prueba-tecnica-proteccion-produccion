# Imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiar el pom.xml y src
COPY pom.xml .
COPY src ./src

# Construir el proyecto
RUN ./mvnw clean package

# Exponer el puerto (Render lo reemplaza dinámicamente)
EXPOSE 10000

# Comando para ejecutar la app
CMD ["java", "-jar", "target/prueba-tickets-0.0.1-SNAPSHOT.jar"]
