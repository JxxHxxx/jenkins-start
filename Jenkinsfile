pipeline {
    agent any

    environment {
            AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
            AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
            API_SERVER_PEM_KEY = credentials('EC2-ACCESS')
        }

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonning Repository'

                git url: 'https://github.com/JxxHxxx/jenkins-start.git',
                    branch: 'master',
                    credentialsId: 'abbfa91f-b62a-4b27-bed8-3300e7cd4e27'
            }
        }

        stage('Test') {
            steps {
                echo 'Test'
                sh './gradlew test'
            }

            post {
                failure {
                    error 'test is fail...'
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Build'
                sh './gradlew build'
            }

            post {
                failure {
                    error 'build is fail...'
                }
            }
        }

        stage('Deploy') {
            steps {
                    sh "ssh -i $API_SERVER_PEM_KEY ubuntu@43.201.76.198 java -jar your-application.jar"
                }
            }
        }
    }
}

