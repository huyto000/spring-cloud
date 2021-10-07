FROM openjdk:11-jre-slim
EXPOSE 8082
RUN pwd
ADD / /etc/filmlisting
RUN cp /etc/filmlisting/target/filmlisting-0.0.1-SNAPSHOT.jar filmlisting-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/filmlisting-0.0.1-SNAPSHOT.jar"]