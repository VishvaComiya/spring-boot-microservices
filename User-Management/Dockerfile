FROM adoptopenjdk:17-jre
WORKDIR /app
COPY target/User-Management-0.0.1-SNAPSHOT.war /app/user-management-service.war
CMD ["java", "-jar", "user-management-service.war"]
