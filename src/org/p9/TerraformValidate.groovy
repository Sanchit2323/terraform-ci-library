package org.p9

class TerraformValidate {
    static void call(steps) {
        steps.stage('Terraform Validate') {
            steps.steps {
                steps.sh 'terraform validate'
            }
        }
    }
}
