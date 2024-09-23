pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'sunnykaushik007/calculator' // Replace with your Docker Hub repo
        DOCKER_TAG = 'latest'
        DOCKER_HUB_CREDS = 'dockerHubCredentials'  // Jenkins credentials ID for Docker Hub`
        PATH = "/opt/homebrew/bin:$PATH:/usr/local/bin" 
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
                // // Login to Docker Hub and push the Docker image
                // script {
                //     docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials') {
                //         docker.image("${DOCKER_IMAGE}:${DOCKER_TAG}").push()
                //     }
                // }
                withCredentials([usernamePassword(credentialsId: "${DOCKER_HUB_CREDS}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh """
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${DOCKER_IMAGE}:${DOCKER_TAG}
                        docker logout
                    """
                }

            }

        }
    }
}