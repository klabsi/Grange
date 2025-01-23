FROM eclipse-temurin:21

COPY gradle/wrapper/* gradle/wrapper/
COPY build.gradle .
COPY gradlew .
COPY settings.gradle .
COPY henhouse henhouse

RUN chmod +x ./gradlew && ./gradlew henhouse:bootJar --no-daemon

ENTRYPOINT java -Dencryptor.password=${entrypoint_password} -jar henhouse/build/libs/henhouse-1.0-SNAPSHOT.jar