FROM eclipse-temurin:21

COPY gradle/wrapper/* gradle/wrapper/
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY home-office home-office

RUN chmod +x ./gradlew && ./gradlew home-office:bootJar --no-daemon

ENTRYPOINT java -Dencryptor.password=${ENTRYPOINT_PASSWORD} -jar home-office/build/libs/home-office-1.0-SNAPSHOT.jar