pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat 'run_tests.bat > test.log'
            }
            post {
                always {
                    emailext(
                        subject: "Test Stage - ${currentBuild.currentResult}",
                        body: "Test stage status: ${currentBuild.currentResult}\nCheck logs attached.",
                        to: 'vikasreddy2708@gmail.com',
                        attachmentsPattern: 'test.log'
                    )
                }
            }
        }

        stage('Security Scan') {
            steps {
                bat 'scan.bat > scan.log'
            }
            post {
                always {
                    emailext(
                        subject: "Security Scan - ${currentBuild.currentResult}",
                        body: "Security scan status: ${currentBuild.currentResult}\nCheck logs attached.",
                        to: 'vikasreddy2708@gmail.com',
                        attachmentsPattern: 'scan.log'
                    )
                }
            }
        }
    }
}
