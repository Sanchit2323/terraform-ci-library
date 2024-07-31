package org.p9

def call() {
    stage('Terraform Format') {
        steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh 'terraform fmt -check -diff > terraform_fmt_report.txt'
            }
        }
    }
}
