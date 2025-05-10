#Start with a base image containing Java runtime
FROM openjdk:17
#Make port 8080 available to the world outside this container
EXPOSE 8080
ADD maven/${project.build.finalName}.jar mywebproject
ENTRYPOINT ["java","-jar", "/mywebproject"]