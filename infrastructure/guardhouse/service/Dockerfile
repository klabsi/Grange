FROM eclipse-temurin:21
ARG appJar=build/libs/guardhouse-1.0-SNAPSHOT.jar
ADD ${appJar} guardhouse.jar
ENTRYPOINT java -jar guardhouse.jar