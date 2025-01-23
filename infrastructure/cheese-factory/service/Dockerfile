FROM eclipse-temurin:21

COPY gradle/wrapper/* gradle/wrapper/
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY cheese-factory cheese-factory

RUN chmod +x ./gradlew && ./gradlew cheese-factory:bootJar --no-daemon

ENTRYPOINT java -Dencryptor.password=${entrypoint_password} -jar cheese-factory/build/libs/cheese-factory-1.0-SNAPSHOT.jar