package org.p9

def call() {
    stage('Terraform Validate') {
        steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh 'terraform validate > terraform_validate_report.txt'
            }
        }
    }
}
