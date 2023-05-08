pipeline {
    agent any

    environment {
            AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
            AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
            API_SERVER_PEM_KEY = credentials('EC2-ACCESS')
        }

    stages {
        stage('Checkout') {
            agent any

            steps {
                echo 'Clonning Repository'

                git url: 'https://github.com/JxxHxxx/jenkins-start.git',
                    branch: 'master',
                    credentialsId: 'abbfa91f-b62a-4b27-bed8-3300e7cd4e27'
            }

            post {
                success {
                    echo 'Successfully Cloned Repository'
                }

                always {
                    echo "i tried..."
                }

                cleanup {
                    // post 작업을 마치고 로그를 남기는 역할
                    echo "after all other post condition"
                }
            }
        }

        stage('Test') {
            steps {
                echo 'Test'
                sh './gradlew test'
            }
        }

        stage('Build') {
            steps {
                echo 'Build'
                sh './gradlew build'
            }

            post {
                failure {
                    error 'This pipeline stops here...'
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

