pipeline {
    agent any // Add this line to specify the agent

    tools {
        maven 'Maven'
    }

    stages {
        stage("build jar") {
            steps {
                script {
                    echo 'building the app...'
                    sh 'mvn clean package'
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo 'building docker image...'
                    withCredentials([usernamePassword(credentialsId: 'amine-docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t aminemighri/demo-java-Ops:2.0 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push aminemighri/demo-java-Ops:2.0'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                    // Add your deployment steps here
                }
            }
        }

        stage('SCM') {
            steps {
                checkout scm
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def mvn = tool 'Maven';
                    withSonarQubeEnv() {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=amine-app-scan -Dsonar.projectName='amine-app-scan'"
                    }
                }
            }
        }
    }
}
