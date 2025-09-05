FROM openjdk:17-jdk-slim AS runtime
WORKDIR /app
COPY target/t2311e-spring-demo-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]

# docker build -t t2311e-spring-demo:1.0 .