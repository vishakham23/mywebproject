FROM openjdk:17
#Make port 8080 available to the world outside this container
EXPOSE 8080
ADD target/mywebproject.jar mywebproject.jar
ENTRYPOINT ["java","-jar", "/mywebproject.jar"]