FROM eclipse-temurin:21

COPY gradle/wrapper/* gradle/wrapper/
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY cowshed cowshed

RUN chmod +x ./gradlew && ./gradlew cowshed:bootJar --no-daemon

ENTRYPOINT java -Dencryptor.password=${ENTRYPOINT_PASSWORD} -jar cowshed/build/libs/cowshed-1.0-SNAPSHOT.jar