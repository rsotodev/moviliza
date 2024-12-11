# Etapa de construcción: utiliza Maven con OpenJDK 11
FROM maven:3.8.6-openjdk-11-slim AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Compila el proyecto y empaqueta el archivo WAR
RUN mvn clean package -DskipTests

# Etapa de despliegue: utiliza Tomcat 9 compatible con OpenJDK 11
FROM tomcat:9.0-jdk11-openjdk-slim

# Configura el conector JDBC para MySQL
RUN apt-get update && apt-get install -y wget \
    && wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-java-5.1.49.tar.gz \
    && tar -xzf mysql-connector-java-5.1.49.tar.gz \
    && mv mysql-connector-java-5.1.49/mysql-connector-java-5.1.49-bin.jar /usr/local/tomcat/lib/ \
    && rm -rf mysql-connector-java-5.1.49*

# Copia el archivo WAR compilado a la carpeta webapps de Tomcat
COPY --from=build /app/target/Moviliza-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exposición del puerto dinámico para Render
EXPOSE $PORT

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
