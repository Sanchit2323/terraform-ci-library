package org.p9

class TerraformLint {
    static void call(steps, tflintPath) {
        steps.stage('Terraform Lint') {
            steps.steps {
                steps.sh "${tflintPath} --init"
                steps.sh "${tflintPath} --enable-rule=terraform"
                steps.sh "${tflintPath} --enable-rule=terraform--terraform-0_12"
                steps.sh "${tflintPath} --enable-rule=terraform--terraform-0_13"
                steps.sh "${tflintPath} --enable-rule=terraform--terraform-0_14"
            }
        }
    }
}

