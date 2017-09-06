pipeline {
    agent any
    parameters {
        string(name: 'helloWorldRepo', defaultValue: 'https://github.com/kchaitali/helloWorld.git', description: 'helloWorld repo')
        string(name: 'gitCredentialsId', defaultValue: '6ccad742-12fa-491a-b034-4c8909331a70', description: 'personal')
    }
stages {
        stage ('delete workspace'){
            steps {
                deleteDir()
            }
        }

        stage ('git clone') {
            steps {
                sh "mkdir hello"
                dir ('hello'){
                    git branch: 'master', credentialsId: "${params.gitCredentialsId}", url: "${params.helloWorldRepo}"
                }
            }
        }
