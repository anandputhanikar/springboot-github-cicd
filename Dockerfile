FROM openjdk:11
EXPOSE 8080
ADD target/cicdspringboot_br1.jar cicdspringboot_br1.jar
ENTRYPOINT ["java","-jar","cicdspringboot_br1.jar"]