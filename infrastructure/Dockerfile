FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre-alpine
COPY --from=build /app/matching-engine-java/build/libs/*.jar /opt/matching.jar
COPY --from=build /app/api-kotlin/build/libs/*.jar /opt/api.jar
ENTRYPOINT ["sh", "-c", "java -jar /opt/matching.jar & java -jar /opt/api.jar"]

