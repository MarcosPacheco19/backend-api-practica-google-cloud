FROM openjdk:17-jdk-alpine
COPY target/backend-api-0.0.1-SNAPSHOT.jar backend-api-0.0.1-SNAPSHOT.jar
ADD https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar .
ENV JAVA_TOOL_OPTIONS "-javaagent:./opentelemetry-javaagent.jar"
CMD ["java", "-jar", "backend-api-0.0.1-SNAPSHOT.jar"]