pipeline {
    agent any
    parameters {
        string(name: 'helloWorldRepo', defaultValue: 'https://github.com/kchaitali/helloWorld.git', description: 'helloWorld repo')
        string(name: 'gitCredentialsId', defaultValue: 'personal', description: 'personal')
    }
stages {
        stage ('delete workspace'){
            steps {
                deleteDir()
            }
        }

        stage('Checkout'){
        git branch: 'master', credentialsId: "${params.gitCredentialsId}", url: "${params.helloWorldRepo}"
        }

        stage('Build') {
    'mvn clean package'
  }

        