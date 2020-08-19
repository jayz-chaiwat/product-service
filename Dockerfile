FROM openjdk:8-jre-alpine
VOLUME /tmp
WORKDIR /app
RUN chmod -R 755 /app
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]