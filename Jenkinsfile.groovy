pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                sh './run_tests.sh | tee test.log'
            }
            post {
                always {
                    emailext(
                        subject: "Test Stage - ${currentBuild.currentResult}",
                        body: "Test stage status: ${currentBuild.currentResult}\nCheck logs attached.",
                        to: 'your-email@gmail.com',
                        attachmentsPattern: 'test.log'
                    )
                }
            }
        }

        stage('Security Scan') {
            steps {
                sh './scan.sh | tee scan.log'
            }
            post {
                always {
                    emailext(
                        subject: "Security Scan - ${currentBuild.currentResult}",
                        body: "Security scan status: ${currentBuild.currentResult}\nCheck logs attached.",
                        to: 'your-email@gmail.com',
                        attachmentsPattern: 'scan.log'
                    )
                }
            }
        }
    }
}
