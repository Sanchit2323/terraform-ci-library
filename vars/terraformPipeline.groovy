def call(String repoUrl = 'https://github.com/Sanchit2323/Terraform-CI.git') {
    pipeline {
        agent any
        environment {
            CHECKOV_PATH = '/var/lib/jenkins/.local/bin'
            TFLINT_PATH = '/usr/local/bin/tflint'
        }
        stages {
            stage('Checkout') {
                steps {
                    git url: "${repoUrl}", branch: 'main'
                }
            }
            stage('Terraform Init') {
                steps {
                    script {
                        org.p9.TerraformUtils.terraformInit()
                    }
                }
            }
            stage('Terraform Format') {
                steps {
                    script {
                        org.p9.TerraformUtils.terraformFormat()
                    }
                }
            }
            stage('Terraform Validate') {
                steps {
                    script {
                        org.p9.TerraformUtils.terraformValidate()
                    }
                }
            }
            stage('Terraform Lint') {
                steps {
                    script {
                        org.p9.TflintUtils.runTflint()
                    }
                }
            }
            stage('Checkov Scan') {
                steps {
                    script {
                        org.p9.CheckovUtils.runCheckov()
                    }
                }
            }
            stage('Archive Reports') {
                steps {
                    echo 'Archiving Reports'
                    archiveArtifacts artifacts: 'terraform_fmt_report.txt, terraform_validate_report.txt, checkov_report.json, tflint_report.json', allowEmptyArchive: true
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
