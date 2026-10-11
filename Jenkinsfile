
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat '"C:\\apache-maven-3.9.16\\bin\\mvn.cmd" package'
            }
        }

        stage('Test') {
            steps {
                bat '"C:\\apache-maven-3.9.16\\bin\\mvn.cmd" test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat '"C:\\apache-maven-3.9.16\\bin\\mvn.cmd" sonar:sonar -Dsonar.projectKey=jenkins-sonarqube-cicd'
                }
            }
        }
    }

    post {
        success {
            echo 'Build, tests, and SonarQube analysis completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
