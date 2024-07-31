package org.p9

def call() {
    stage('Terraform Init') {
        steps {
            catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                sh 'terraform init'
            }
        }
    }
}
