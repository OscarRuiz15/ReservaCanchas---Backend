FROM openjdk:8
COPY ./build/libs/* .
EXPOSE 8080
ENTRYPOINT ["java","-jar","reservascanchas-0.0.1.jar"]