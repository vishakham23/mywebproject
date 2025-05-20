pipeline{
    agent any
    tools{
        maven 'mymaven3.9.9'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/vishakham23/mywebproject']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                bat 'docker build -t vishwell/mywebproject:1.0 .'
                // bat 'docker build -t vishwell/mywebproject:latest.'
            }
        }
        stage('push docker image to docker hub'){
            steps{
              withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                 // sh 'docker login -u vishwell -p ${dockerhubpwd}'
                   bat 'docker login -u vishwell -p %dockerhubpwd%'
                }
                bat 'docker push vishwell/mywebproject:1.0'
               // bat 'docker push vishwell/mywebproject:latest'
            }
        }

    }
}