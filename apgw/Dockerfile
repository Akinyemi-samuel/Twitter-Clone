FROM openjdk:17
LABEL maintainer="{akinywmi samuel <akinyemisamuelayo@gmail.com>}"
WORKDIR /app
COPY target/apgw-jar-file.jar /app
ENTRYPOINT ["java", "-jar", "/app/apgw-jar-file.jar"]
EXPOSE 8082