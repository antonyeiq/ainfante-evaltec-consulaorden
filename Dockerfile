FROM openjdk:11
VOLUME [ "/data" ]
EXPOSE 8888
ADD target/ainfante-evaltec-consulaorden-0.0.1-SNAPSHOT.jar app-evaltec-consultaorden.jar
ENTRYPOINT ["java","-jar","/app-evaltec-consultaorden.jar"]