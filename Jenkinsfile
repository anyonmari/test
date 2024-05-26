pipeline {
    agent any

    tools {
        maven 'maven jenkins'
    }

    stages {
        stage('Build') {
            steps {
                // Получить код из репозитория GitHub
                git 'https://github.com/anyonmari/test.git'
                sh 'mvn clean test'
                sh 'ls -la target/allure-results'
            }
        }
    }

    post {
        always {
            // Генерация отчета Allure
            script {
                allure includeProperties: false, jdk: '1.8', results: [[path: 'target/allure-results']]
            }
            // Архивирование артефактов и запись результатов тестов
            archiveArtifacts artifacts: '**/target/allure-results/**', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}