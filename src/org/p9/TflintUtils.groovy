package org.p9

class TflintUtils {
    static void runTflint() {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            sh """
                /usr/local/bin/tflint --format json > tflint_report.json
            """
        }
    }
}
