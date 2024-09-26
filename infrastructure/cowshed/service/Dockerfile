FROM eclipse-temurin:21
ARG appJar=build/libs/cowshed-1.0-SNAPSHOT.jar
ADD ${appJar} cowshed.jar
ENTRYPOINT java -jar cowshed.jar