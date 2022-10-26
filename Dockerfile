FROM openjdk:11
EXPOSE 8080
ADD target/cicdspringboot.jar cicdspringboot.jar
ENTRYPOINT ["java","-jar","cicdspringboot.jar"]