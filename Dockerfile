FROM eclipse-temurin:11-jdk
VOLUME /tmp
ARG JAR_FILE=target/findmytutor-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]