package org.p9

class TerraformInit {
    static void call() {
        stage('Terraform Init') {
            steps {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh 'terraform init'
                }
            }
        }
    }
}
