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
                echo 'Clonning Repository'

                git url: 'https://github.com/JxxHxxx/jenkins-start.git',
                    branch: 'master',
                    credentialsId: 'abbfa91f-b62a-4b27-bed8-3300e7cd4e27'
            }
        }

        stage('Build') {
            steps {
                echo 'Build'
                dir('/') {
                    sh 'chmod +x ./gradlew build'
                }
            }

            post {
                failure {
                    error 'build is fail...'
                }
            }
        }
    }
}


//             stage('Deploy') {
//                 steps {
//                     withCredentials([sshUserPrivateKey(credentialsId: 'EC2-ACCESS', keyFileVariable: 'PEM_KEY')]) {
//                         sh 'scp -o StrictHostKeyChecking=no -i /var/lib/jenkins/key-morak.pem ./*.jar ubuntu@$43.201.76.198:/home/ubuntu'
//                         sh "ssh -o StrictHostKeyChecking=no -i $PEM_KEY ubuntu@43.201.76.198 java -jar jenkins-start-0.0.1-SNAPSHOT.jar"
//                     }
//                 }
//             }


//         stage('Test') {
//             steps {
//                 echo 'Test'
//                 dir('/') {
//                     sh 'chmod +x ./gradlew test'
//                 }
//             }
//
//             post {
//                 failure {
//                     error 'test is fail...'
//                 }
//             }
//         }