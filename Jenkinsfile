pipeline {
    agent any

    tools {
        maven 'Maven'   // Must match the name configured in Jenkins Global Tool Configuration
        // jdk 'JDK21'  // Uncomment only if you configured JDK in Jenkins tools
    }

    stages {

        stage('Checkout from GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Ragulgit-hub/ragul-ci-cd-pipeline-project.git'
            }
        }

        stage('Build & Test with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Application Output') {
            steps {
                echo "Executing the application to print the welcome message..."
                bat 'java -cp target\\classes com.ragul.cicd.App'
                // For Linux users: sh 'java -cp target/classes com.ragul.cicd.App'
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
            mail to: 'ragul493@gmail.com',
                 subject: 'Jenkins: SUCCESS - Ragul CI/CD Pipeline',
                 body: "Good news! The Jenkins job '${env.JOB_NAME}' build #${env.BUILD_NUMBER} succeeded.\n\nSee details: ${env.BUILD_URL}"
        }
        failure {
            echo 'Pipeline failed!'
            mail to: 'ragul493@gmail.com',
                 subject: 'Jenkins: FAILURE - Ragul CI/CD Pipeline',
                 body: "Oops. The Jenkins job '${env.JOB_NAME}' build #${env.BUILD_NUMBER} failed.\n\nSee details: ${env.BUILD_URL}"
        }
    }
}
