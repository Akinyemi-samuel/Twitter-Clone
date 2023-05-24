FROM openjdk:17
LABEL maintainer="{Akinyemi samuel <akinyemisamuelayo@gmail.com>}"
WORKDIR /app
COPY target/eureka-jar-file.jar /app
ENTRYPOINT ["java", "-jar", "/app/eureka-jar-file.jar"]
EXPOSE 8761