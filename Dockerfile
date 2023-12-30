FROM openjdk:21
VOLUME /tmp
COPY target/*.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9090