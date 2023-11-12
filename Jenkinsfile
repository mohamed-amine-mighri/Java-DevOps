pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
        stage("build jar") {
            steps {
                script {
                    echo 'building the app...'
                    sh 'mvn install'
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo 'building docker image...'
                    withCredentials([usernamePassword(credentialsId: 'amine-docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t aminemighri/demo-java-Ops:2.0'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push aminemighri/demo-java-Ops:jma-2.0'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }

        stage('SCM') {
            steps {
                script {
                    echo 'Checking out code...'
                    checkout scm
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    echo 'Running SonarQube Analysis...'
                    def mvn = tool 'Maven'
                    withSonarQubeEnv() {
                        sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=amine-app-scan -Dsonar.projectName='amine-app-scan'"
                    }
                }
            }
        }
    }
}
