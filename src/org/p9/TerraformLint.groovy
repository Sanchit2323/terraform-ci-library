package org.p9

def call(String tflintPath) {
    stage('Terraform Lint') {
        steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh """
                    ${tflintPath} --format json > tflint_report.json
                """
            }
        }
    }
}
