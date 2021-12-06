FROM openjdk:11-jre-slim
ENV EXTERNAL_CONFIGURATION_LOCATION /config/application.properties
EXPOSE 8081
RUN pwd
ADD / /etc/booklisting
RUN cp /etc/booklisting/target/booklisting-0.0.1-SNAPSHOT.jar booklisting-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","/booklisting-0.0.1-SNAPSHOT.jar","--spring.config.location=${EXTERNAL_CONFIGURATION_LOCATION}"]
