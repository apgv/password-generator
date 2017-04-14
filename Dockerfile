FROM gcr.io/google_appengine/openjdk

VOLUME /tmp

RUN apt-get update && apt-get install apg -y

ADD build/libs/password-generator-all-1.0.jar app.jar

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]