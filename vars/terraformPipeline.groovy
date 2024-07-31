def call() {
    pipeline {
        agent any

        stages {
            stage('Checkout') {
                steps {
                    git 'https://github.com/Sanchit2323/Terraform-CI.git'
                }
            }
            stage('Terraform Init') {
                steps {
                    src.TerraformInit.init()
                }
            }
            stage('Terraform Format') {
                steps {
                    src.TerraformFmt.format()
                }
            }
            stage('Terraform Validate') {
                steps {
                    src.TerraformValidate.validate()
                }
            }
            stage('Checkov Scan') {
                steps {
                    src.TerraformCheckov.scan()
                }
            }
            stage('Archive Reports') {
                steps {
                    echo 'Archiving Reports'
                    archiveArtifacts artifacts: '**/checkov_report.json, **/terraform_fmt_report.txt, **/terraform_validate_report.txt'
                }
            }
        }
        
        post {
            always {
                cleanWs()
            }
        }
    }
}
