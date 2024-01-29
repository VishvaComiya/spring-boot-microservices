FROM adoptopenjdk:17-jre
WORKDIR /app
COPY target/Product-Catalog-0.0.1-SNAPSHOT.war /app/product-catalog-service.war
CMD ["java", "-jar", "product-catalog-service.war"]
