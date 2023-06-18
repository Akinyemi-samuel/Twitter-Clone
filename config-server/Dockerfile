FROM openjdk:17
LABEL maintainer="{Akinyemi samuel <akinyemisamuelayo@gmail.com>}"
WORKDIR /app
COPY target/config-jar-file.jar /app
ENTRYPOINT ["java", "-jar", "/app/config-jar-file.jar"]
EXPOSE 8081