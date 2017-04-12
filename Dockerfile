FROM openjdk:8-jre-alpine

RUN apk add --no-cache apg

COPY build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]