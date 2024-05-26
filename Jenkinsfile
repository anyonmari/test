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

           stage('Allure Report') {
               steps {
                   allure includeProperties: false, jdk: '1.7', results: [[path: 'target/allure-results']]
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