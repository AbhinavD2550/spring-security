FROM openjdk:8
EXPOSE 8080
ARG JAR_FILE=./target/SpringSecurityTest-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} SpringSecurityTest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/SpringSecurityTest-0.0.1-SNAPSHOT.jar"]