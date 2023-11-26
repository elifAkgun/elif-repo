FROM openjdk:17-alpine
VOLUME /tmp
COPY target/SpringBootUnitTestExamples-0.0.1-SNAPSHOT.jar my-project.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/my-project.jar"]