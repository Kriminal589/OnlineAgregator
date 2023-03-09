FROM openjdk:17
COPY ./build/libs/* app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "app.jar"]
