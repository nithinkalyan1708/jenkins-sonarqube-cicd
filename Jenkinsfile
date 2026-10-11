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
                bat 'echo Checking Windows command execution'
                bat 'where cmd.exe'
                bat 'where java.exe'
                bat 'java -version'
                bat 'cmd.exe /d /c "echo CMD execution works"'
                bat 'cmd.exe /d /c "C:\\apache-maven-3.9.16\\bin\\mvn.cmd --version"'
            }
        }

        stage('Test') {
            steps {
                bat 'cmd.exe /d /c ""C:\\apache-maven-3.9.16\\bin\\mvn.cmd" test"'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'cmd.exe /d /c ""C:\\apache-maven-3.9.16\\bin\\mvn.cmd" sonar:sonar -Dsonar.projectKey=jenkins-sonarqube-cicd"'
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
