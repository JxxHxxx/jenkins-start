pipeline {
    agent any

    environment {
            AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
            AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
            API_SERVER_PEM_KEY = credentials('EC2-ACCESS')
        }

    tools {
        gradle '7.6.1'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning Repository'

                git url: 'https://github.com/JxxHxxx/jenkins-start.git',
                    branch: 'master',
                    credentialsId: 'abbfa91f-b62a-4b27-bed8-3300e7cd4e27'
            }
        }

        stage('Test') {
            steps {
                echo 'Test'
                dir('/var/lib/jenkins/workspace/practice') {
                    sh 'gradle test'
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Build'
                dir('/var/lib/jenkins/workspace/practice') {
                    sh 'gradle build'
                }
            }
        }

        stage('Deploy') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'EC2-ACCESS', keyFileVariable: 'PEM_KEY')]) {
                    dir('/var/lib/jenkins/workspace/practice/build/libs') {
                        sh "scp -o StrictHostKeyChecking=no -i $PEM_KEY jenkins-start-0.0.1-SNAPSHOT.jar ubuntu@43.201.76.198:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no -i $PEM_KEY ubuntu@43.201.76.198 pkill -f jenkins-start-0.0.1-SNAPSHOT.jar"
                        sh "ssh -o StrictHostKeyChecking=no -i $PEM_KEY ubuntu@43.201.76.198 java -jar /home/ubuntu/jenkins-start-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &"
                    }
                }
            }
        }
    }
}


