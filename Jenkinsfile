pipeline {
    agent any

    tools {
        maven 'Maven'   // Must match the name in Global Tool Configuration
        // jdk 'JDK21'    // Uncomment if you configured a JDK tool
    }

    stages {
        stage('Checkout from GitHub') {
            steps {
                // If your repo is public, you can omit credentialsId
                git branch: 'main',
                    url: 'https://github.com/<your-username>/ragul-ci-cd-pipeline-project.git'
            }
        }

        stage('Build & Test with Maven') {
            steps {
                // For Windows Jenkins nodes
                bat 'mvn clean package'
                // If Jenkins runs on Linux, use:
                // sh 'mvn clean package'
            }
        }

        stage('Archive Build Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
            mail to: 'your-email@example.com',
                 subject: 'Jenkins: SUCCESS - Ragul CI/CD Pipeline',
                 body: "Good news! The Jenkins job '${env.JOB_NAME}' build #${env.BUILD_NUMBER} succeeded.\n\nSee details: ${env.BUILD_URL}"
        }
        failure {
            echo 'Pipeline failed!'
            mail to: 'your-email@example.com',
                 subject: 'Jenkins: FAILURE - Ragul CI/CD Pipeline',
                 body: "Oops. The Jenkins job '${env.JOB_NAME}' build #${env.BUILD_NUMBER} failed.\n\nSee details: ${env.BUILD_URL}"
        }
    }
}
