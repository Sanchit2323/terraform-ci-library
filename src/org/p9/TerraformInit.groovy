package org.p9

class TerraformInit {
    static void call(steps) {
        steps.stage('Terraform Init') {
            steps.steps {
                steps.catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    steps.sh 'terraform init'
                }
            }
        }
    }
}

