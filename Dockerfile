FROM eclipse-temurin:21.0.7_6-jdk
RUN mkdir /opt/app
COPY target/market-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "/opt/app/market-0.0.1-SNAPSHOT.jar"]
