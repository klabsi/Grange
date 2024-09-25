FROM eclipse-temurin:21
ARG appJar=build/libs/home-office-1.0-SNAPSHOT.jar
ADD ${appJar} home-office.jar
ENTRYPOINT java -jar home-office.jar