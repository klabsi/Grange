FROM eclipse-temurin:21
ARG appJar=build/libs/cheese-factory-1.0-SNAPSHOT.jar
ADD ${appJar} cheese-factory.jar
ENTRYPOINT java -Dspring.datasource.username=${db_username} -Dspring.datasource.password=${db_password} -jar cheese-factory.jar