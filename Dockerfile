# Step 1: Use a Maven image with JDK 11 to build the project
FROM maven:3.9.0

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Maven project files to the working directory
#contains dependencies, plugins and project configurations 
COPY pom.xml . 
COPY src ./src

# Step 4: Run Maven build (including tests), here skipping the test cases during the build process to save time
# mvn install packages everything as JAR file, and places it into a target file
RUN mvn clean install -DskipTests

# Step 5: Define the command to run the application
#java: command to run the java application, -jar: indicates app is packages as jar file, "target...": indicates the path to the jar file created by maven
ENTRYPOINT ["java", "-jar", "target/demo-1.0.0.jar"]
