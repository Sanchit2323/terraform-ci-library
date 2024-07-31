def call(Map params) {
    pipeline {
        agent any
        environment {
            CHECKOV_PATH = '/var/lib/jenkins/.local/bin'
            TFLINT_PATH = '/usr/local/bin/tflint' // Adjust the path if tflint is installed elsewhere
        }
        parameters {
            string(name: 'REPO_URL', defaultValue: 'https://github.com/Sanchit2323/Terraform-CI.git', description: 'GitHub repository URL')
        }
        stages {
            stage('Checkout') {
                steps {
                    git url: "${params.REPO_URL}", branch: 'main'
                }
            }
            script {
                org.example.TerraformInit.call()
                org.example.TerraformFormat.call()
                org.example.TerraformValidate.call()
                org.example.TerraformLint.call(env.TFLINT_PATH)
                org.example.CheckovScan.call(env.CHECKOV_PATH)
                org.example.ArchiveReports.call()
            }
        }
        post {
            always {
                cleanWs()
                echo 'Pipeline completed'
            }
        }
    }
}
