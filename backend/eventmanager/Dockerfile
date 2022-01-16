FROM maven:3.8-jdk-11
ENV APP_HOME=/user/app/
WORKDIR $APP_HOME
COPY target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]