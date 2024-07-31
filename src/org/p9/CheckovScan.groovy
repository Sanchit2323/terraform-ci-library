package org.p9

def call(String checkovPath) {
    stage('Checkov Scan') {
        steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh """
                    cd ${env.WORKSPACE}
                    ${checkovPath}/checkov -d . -s --output-file-path checkov_report.json
                """
                sh 'ls -l'
            }
        }
    }
}
