package org.p9

class CheckovScan {
    static void call(steps, checkovPath) {
        steps.stage('Checkov Scan') {
            steps.steps {
                steps.sh "${checkovPath}/checkov -d ."
            }
        }
    }
}
