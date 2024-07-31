package org.p9

class TerraformFormat {
    static void call(steps) {
        steps.stage('Terraform Format') {
            steps.steps {
                steps.sh 'terraform fmt -check'
            }
        }
    }
}

