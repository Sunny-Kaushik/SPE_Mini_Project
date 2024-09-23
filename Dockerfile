# Step 1: Use a Maven image with JDK 11 to build the project
FROM maven:3.9.0

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the Maven project files to the working directory
COPY pom.xml .
COPY src ./src

# Step 4: Run Maven build (including tests)
RUN mvn clean install -DskipTests

# Step 8: Define the command to run the application
ENTRYPOINT ["java", "-jar", "target/demo-1.0.0.jar"]
