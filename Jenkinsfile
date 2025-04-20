pipeline {
    agent any

    tools {
        maven 'maven3' // Matches the name from Global Tool Configuration
    }

    environment {
        IMAGE_NAME          = "dilsadmohammed4/student-portal-backend"
        IMAGE_TAG           = "1.0.0"
        REGISTRY_CREDENTIALS = 'dockerhub-credentials' // Jenkins credential ID
        KUBECONFIG          = 'C:/Users/dilsa/.kube/config' // Full path (e.g., C:\Users\dilsa\.kube\config or /home/jenkins/.kube/config)
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $IMAGE_NAME:$IMAGE_TAG ."
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${REGISTRY_CREDENTIALS}", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                    sh "docker push $IMAGE_NAME:$IMAGE_TAG"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh '''
                # Apply deployment and service YAMLs (optional but preferred)
                kubectl apply -f k8s/deployment.yaml
                kubectl apply -f k8s/service.yaml

                # Then update the image
                kubectl set image deployment/student-portal-deployment student-portal-backend=$IMAGE_NAME:$IMAGE_TAG --namespace=default
                '''
            }
        }
    }

    post {
        success {
            echo "Deployment completed successfully!"
        }
        failure {
            echo "Something went wrong!"
        }
    }
}
