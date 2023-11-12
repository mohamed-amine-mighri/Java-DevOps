pipeline{
    agent  an
    tools{
        maven 'Maven'
    }
    stages{
        stage("build jar"){
            steps{
                script{
                    echo 'building the app...'
                    sh 'mvn package'
                }
            }
        }

        stage("build image"){
            steps{
                script{
                    echo 'building docker image...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh 'docker build -t aminemighri/demo-repo:2.0'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push aminemighri/demo-repo:jma-2.0'
                    }
                }
            }
        }

        stage("deploy"){
            steps{
                script{
                    echo "deploying the application..."
                }
            }
        }

        node {
          stage('SCM') {
            checkout scm
          }
          stage('SonarQube Analysis') {
            def mvn = tool 'Default Maven';
            withSonarQubeEnv() {
              sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=amine-app-scan -Dsonar.projectName='amine-app-scan'"
            }
          }
        }
    }
}

