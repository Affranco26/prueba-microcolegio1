# ------------------------------------------------------------------------
#
# Directorio de ubicacion de todos los microservicio /opt/<NOMBRE>
#
# docker build -f Dockerfile -t prueba-microcolegio1 .
# 
# ------------------------------------------------------------------------

FROM openjdk:11-jre-slim-buster
RUN apt-get update && apt-get install curl -y
COPY ./src/prueba-microcolegio1.jar /opt/microservice/prueba-microcolegio1.jar
ENTRYPOINT ["java","-jar","/opt/microservice/prueba-microcolegio1.jar"]