FROM eclipse-temurin:21
ARG appJar=build/libs/henhouse-1.0-SNAPSHOT.jar
ADD ${appJar} henhouse.jar
ENTRYPOINT java -Dspring.datasource.username=${db_username} -Dspring.datasource.password=${db_password} -jar henhouse.jar