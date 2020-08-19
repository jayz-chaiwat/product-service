FROM openjdk:8-jre-alpine
VOLUME /tmp
WORKDIR /app
RUN chmod -R 755 /app
ADD target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]