FROM adoptopenjdk:17-jre
WORKDIR /app
COPY target/Order-Processing-0.0.1-SNAPSHOT.war /app/order-processing-service.war
CMD ["java", "-jar", "order-processing-service.war"]
