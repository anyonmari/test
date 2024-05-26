pipeline {
    agent any
    tools {
        maven 'Maven 3.8.1'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
                sh 'ls -la target/allure-results'
            }
        }
        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/allure-results/**', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}