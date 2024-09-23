pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'sunnykaushik007/calculator' // Replace with your Docker Hub repo
        DOCKER_TAG = 'latest'
        DOCKER_HUB_CREDS = 'dockerHubCredentials'  // Jenkins credentials ID for Docker Hub
    }

    
    stages {
        stage('Test') {
            steps {
                // Run Maven tests
                sh '/opt/homebrew/bin/mvn clean test'
            }
        }

        stage('Build') {
            steps {
                // Build the Docker image using sh command
                sh """
                    /usr/local/bin/docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .
                """
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Login to Docker Hub, tag the image, and push it
                withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDS}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        echo "$DOCKER_PASS" | /usr/local/bin/docker login -u "$DOCKER_USER" --password-stdin
                        /usr/local/bin/docker push ${DOCKER_IMAGE}:${DOCKER_TAG}
                        /usr/local/bin/docker logout
                    """
                }
            }
        }
    }
}