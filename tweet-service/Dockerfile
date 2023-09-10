FROM openjdk:17
LABEL authors="{Akinyemi samuel <samfrosh673@gmail.com>}"
WORKDIR /app
COPY target/tweet-jar-file.jar /app
ENTRYPOINT ["java", "-jar", "/app/tweet-jar-file.jar"]
EXPOSE 8084