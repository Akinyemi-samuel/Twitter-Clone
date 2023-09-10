FROM openjdk:17
LABEL authors="{Akinyemi samuel <akinyemi@gmail.com>}"
WORKDIR /app
COPY target/user-jar-file.jar /app
ENTRYPOINT ["java", "-jar", "/app/user-jar-file.jar"]
EXPOSE 8083