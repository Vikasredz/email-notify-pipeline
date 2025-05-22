pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    // Run tests and capture output
                    def output = bat(returnStdout: true, script: 'run_tests.bat').trim()
                    writeFile file: 'test.log', text: output
                }
            }
            post {
                always {
                    emailext(
                        subject: "Test Stage - ${currentBuild.currentResult}",
                        body: "Test stage status: ${currentBuild.currentResult}\nCheck attached logs.",
                        to: 'vikasreddy2708@gmail.com',
                        attachmentsPattern: 'test.log'
                    )
                }
            }
        }

        stage('Security Scan') {
            steps {
                script {
                    // Run security scan and capture output
                    def output = bat(returnStdout: true, script: 'scan.bat').trim()
                    writeFile file: 'scan.log', text: output
                }
            }
            post {
                always {
                    emailext(
                        subject: "Security Scan - ${currentBuild.currentResult}",
                        body: "Security scan status: ${currentBuild.currentResult}\nCheck attached logs.",
                        to: 'vikasreddy2708@gmail.com',
                        attachmentsPattern: 'scan.log'
                    )
                }
            }
        }
    }
}
