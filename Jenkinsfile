pipeline {
    agent any

    environment {
            AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
            AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
            API_SERVER_PEM_KEY = credentials('EC2-ACCESS')
            API_REMOTE_SERVER_IP = credentials('apiServerIP')
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
                        sh "scp -o StrictHostKeyChecking=no -i $PEM_KEY jenkins-start-0.0.1-SNAPSHOT.jar ubuntu@$API_REMOTE_SERVER_IP:/home/ubuntu"
                        sh "ssh -o StrictHostKeyChecking=no -i $PEM_KEY ubuntu@$API_REMOTE_SERVER_IP pkill -f jenkins-start-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &"
                        sh "ssh -o StrictHostKeyChecking=no -i $PEM_KEY ubuntu@$API_REMOTE_SERVER_IP java -jar /home/ubuntu/jenkins-start-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &"
                    }
                }
            }
        }
    }
}


