pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    def output = bat(returnStdout: true, script: 'run_tests.bat')
                    writeFile file: 'test.log', text: output
                }
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
                script {
                    def output = bat(returnStdout: true, script: 'scan.bat')
                    writeFile file: 'scan.log', text: output
                }
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
