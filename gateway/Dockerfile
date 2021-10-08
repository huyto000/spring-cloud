FROM openjdk:11-jre-slim
EXPOSE 8080
RUN pwd
ADD / /etc/gateway
RUN cp /etc/gateway/target/gateway-0.0.1-SNAPSHOT.jar gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=k8s", "/gateway-0.0.1-SNAPSHOT.jar"]