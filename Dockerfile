# Usa una imagen de Maven con OpenJDK 11 para compilar el proyecto
FROM maven:3.8.6-openjdk-11-slim AS build

# Directorio de trabajo donde copiamos el código fuente
WORKDIR /app

# Copiamos todo el código fuente al contenedor
COPY . /app

# Ejecutamos Maven para construir el WAR
RUN mvn clean package -DskipTests

# Usamos una imagen de Tomcat para ejecutar el archivo WAR
FROM tomcat:9.0-jdk11-openjdk-slim

# Copiamos el archivo WAR a la carpeta webapps de Tomcat
COPY --from=build /app/target/Moviliza-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exponemos el puerto 8080 (puerto por defecto de Tomcat)
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
