FROM eclipse-temurin:21

COPY gradle/wrapper/* gradle/wrapper/
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY guardhouse guardhouse

RUN chmod +x ./gradlew && ./gradlew guardhouse:bootJar --no-daemon

ENTRYPOINT java -Dencryptor.password=${entrypoint_password} -jar guardhouse/build/libs/guardhouse-1.0-SNAPSHOT.jar