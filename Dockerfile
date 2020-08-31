FROM smenaka1104/anduna-api:01.00

COPY target/*.jar Anduna.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Anduna.jar"]