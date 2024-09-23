pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'sunnykaushik007/calculator'
        DOCKER_TAG = 'latest'
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

                // Build the Docker image
                script {
                    docker.build("${DOCKER_IMAGE}:${DOCKER_TAG}")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Login to Docker Hub and push the Docker image
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
                        docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").push()
                    }
                }
            }
        }
    }
}