pipeline {
    agent any

    tools {
        maven 'maven jenkins'
    }

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/anyonmari/test.git'
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean test'
                sh 'ls -la target/allure-results' // Проверка наличия результатов Allure
            }
        }
    }

    post {
        always {
            // Генерация и сохранение отчета Allure в директории target/allure-report
            script {
                sh 'allure generate target/allure-results --clean'
                sh 'allure serve target/allure-results'
            }
            // Архивирование артефактов и запись результатов тестов
            archiveArtifacts artifacts: '**/target/allure-report/**', allowEmptyArchive: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}