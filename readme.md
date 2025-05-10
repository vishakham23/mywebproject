
To push docker image using docker-maven-plugin use the following steps:
-----------------------------------------------------------------------
Step1: Use the latest version for docker-maven-plugin
-----------------------------------------------------
<plugin>
		<groupId>io.fabric8</groupId>
		<artifactId>docker-maven-plugin</artifactId>
		<version>0.45.1</version> <!-- Version of the plugin -->
		<configuration>
			<verbose>true</verbose>
			<images>
				<image>
					<name>vishwell/${project.artifactId}</name>
					<build>
						<assembly>
							<descriptorRef>artifact</descriptorRef>
						</assembly>
						<dockerFileDir>${project.basedir}</dockerFileDir>
						<tags>
							<tag>latest</tag>
							<tag>${project.version}</tag>
						</tags>
					</build>
				</image>
			</images>
		</configuration>
</plugin>

Step2: Dockerfile
-----------------
FROM openjdk:17
EXPOSE 8080
ADD maven/${project.build.finalName}.jar myspringboot-docker-mvn
ENTRYPOINT ["java","-jar", "/myspringboot-docker-mvn"]

Step3: Run the maven commands to build and push docker image to DockerHub
-------------------------------------------------------------------------
3a) mvn clean package
3b) From Maven -> Plugins -> docker - run the below commands
 docker:build
 docker:push

-----------------------------------------------------------------------