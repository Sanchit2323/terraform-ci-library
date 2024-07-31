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
            stage('Terraform Init') {
                steps {
                    script {
                        org.p9.TerraformInit.call()
                    }
                }
            }
            stage('Terraform Format') {
                steps {
                    script {
                        org.p9.TerraformFormat.call()
                    }
                }
            }
            stage('Terraform Validate') {
                steps {
                    script {
                        org.p9.TerraformValidate.call()
                    }
                }
            }
            stage('Terraform Lint') {
                steps {
                    script {
                        org.p9.TerraformLint.call(env.TFLINT_PATH)
                    }
                }
            }
            stage('Checkov Scan') {
                steps {
                    script {
                        org.p9.CheckovScan.call(env.CHECKOV_PATH)
                    }
                }
            }
            stage('Archive Reports') {
                steps {
                    script {
                        org.p9.ArchiveReports.call()
                    }
                }
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
